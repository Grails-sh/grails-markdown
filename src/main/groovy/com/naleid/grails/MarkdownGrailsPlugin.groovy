package com.naleid.grails

import grails.plugins.Plugin

class MarkdownGrailsPlugin extends Plugin {

	def grailsVersion = '3.0.0 > *'
	def author = "Ted Naleid"
	def authorEmail = "contact@naleid.com"
	def title = "Grails Markdown Plugin"
	def developers = [
		[name: "Phil DeJarnett"]
	]
	def description = 'Provides a tag library and service support for Markdown'
	def documentation = "https://bitbucket.org/tednaleid/grails-markdown"
	def issueManagement = [url: 'https://bitbucket.org/tednaleid/grails-markdown/issues']
	def scm = [url: "https://bitbucket.org/tednaleid/grails-markdown"]
	def license = 'APACHE'

	void doWithDynamicMethods() {
		MarkdownPluginSupport.doWithDynamicMethods applicationContext.markdownService
	}
}
