package asset.pipeline.groovytemplate

import asset.pipeline.AbstractAssetFile

class JavascriptGroovyTemplateAssetFile extends AbstractAssetFile {
	static final String contentType = 'application/javascript'
	static extensions = ['js-gtpl']
	static final String compiledExtension = 'js'
	static processors = [GroovyTemplateProcessor]

	String directiveForLine(String line) {
		return null
	}
}
