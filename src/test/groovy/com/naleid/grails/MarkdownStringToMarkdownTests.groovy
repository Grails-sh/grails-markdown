package com.naleid.grails

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * Tests the String.metaClass.markdownToHtml() method.
 */
@TestMixin(GrailsUnitTestMixin)
class MarkdownStringToMarkdownTests extends Specification {

	void setup() {
		defineBeans {
			markdownService(MarkdownService) {
				grailsApplication = ref('grailsApplication')
			}
		}

		MarkdownPluginSupport.doWithDynamicMethods applicationContext.markdownService
	}

	void 'string markdown to HTML'() {
		expect:
		'<p><a href="http://example.net/">This link</a> has no title attribute.</p>' ==
				  '[This link](http://example.net/) has no title attribute.'.markdownToHtml()
	}
}
