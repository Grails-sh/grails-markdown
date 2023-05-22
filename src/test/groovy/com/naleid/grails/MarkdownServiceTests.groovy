package com.naleid.grails

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MarkdownService)
class MarkdownServiceTests extends Specification {

	void 'markdown to HTML'() {
		expect:
		'<p><a href="http://example.net/">This link</a> has no title attribute.</p>' ==
				  service.markdown('[This link](http://example.net/) has no title attribute.')
	}

	void 'HTML to markdown'() {
		expect:
		'[This link][] has no title attribute.\n\n\n[This link]: http://example.net/' ==
				  service.htmlToMarkdown('<p><a href="http://example.net/">This link</a> has no title attribute.</p>')
	}

	void 'custom pegdown settings'() {
		when:
		String expected = '<p>Auto-linking Enabled: <a href="http://example.net/">http://example.net/</a></p>'
		String text = 'Auto-linking Enabled: http://example.net/'

		then:
		expected == service.markdown(text, [all: true])
		expected != service.markdown(text)
	}

	void 'custom remark settings'() {
		when:
		String expected = '"Smart-Quotes" --- and em-dashes'
		String text = '&ldquo;Smart-Quotes&rdquo; &mdash; and em-dashes'

		then:
		expected == service.htmlToMarkdown(text, "", [all: true])
		expected != service.htmlToMarkdown(text)
	}
}
