package com.naleid.grails

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MarkdownTagLib)
class MarkdownTagLibTests extends Specification {

	void setup() {
		defineBeans {
			markdownService(MarkdownService) {
				grailsApplication = ref('grailsApplication')
			}
		}
	}

	void 'due to a bug, DI is not done for the first test, so this is here as a workaround'() {
		expect: true
	}

	void 'render HTML using body'() {
		expect:
		'<p>This is a <em>test</em> of markdown.</p>' == applyTemplate(
				  '<markdown:renderHtml>This is a *test* of markdown.</markdown:renderHtml>')
	}

	void 'render HTML using attribute'() {
		expect:
		'<p>Yet <strong>another</strong> markdown test.</p>' == applyTemplate(
				  '<markdown:renderHtml text="Yet **another** markdown test."/>')
	}
}
