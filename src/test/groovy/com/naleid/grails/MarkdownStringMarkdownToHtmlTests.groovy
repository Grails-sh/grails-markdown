package com.naleid.grails

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * Tests the String.metaClass.htmlToMarkdown() method.
 */
@TestMixin(GrailsUnitTestMixin)
class MarkdownStringMarkdownToHtmlTests extends Specification {

	void setup() {
		defineBeans {
			markdownService(MarkdownService) {
				grailsApplication = ref('grailsApplication')
			}
		}

		MarkdownPluginSupport.doWithDynamicMethods applicationContext.markdownService
	}

	void 'string HTML to markdown'() {
		expect:
		'[This link][] has no title attribute.\n\n\n[This link]: http://example.net/' ==
				  '<p><a href="http://example.net/">This link</a> has no title attribute.</p>'.htmlToMarkdown()
	}
}
