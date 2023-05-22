package com.naleid.grails

import org.pegdown.PegDownProcessor

class MarkdownPluginSupport {

	static void doWithDynamicMethods(MarkdownService markdownService) {
		String.metaClass.markdownToHtml = {
			markdownService.markdown(delegate)
		}

		String.metaClass.htmlToMarkdown = {
			markdownService.htmlToMarkdown(delegate)
		}

		// allow backwards-compatible markdownService.processor.markdown(text)
		PegDownProcessor.metaClass.markdown = { text ->
			delegate.markdownToHtml(text.toString())
		}
	}
}
