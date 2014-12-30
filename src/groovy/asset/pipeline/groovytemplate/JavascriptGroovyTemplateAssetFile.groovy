package asset.pipeline.groovytemplate

import asset.pipeline.AbstractAssetFile
import groovy.transform.CompileStatic

@CompileStatic
class JavascriptGroovyTemplateAssetFile extends AbstractAssetFile {
	static final String contentType = 'application/javascript'
	static extensions = ['js-gtpl']
	static final String compiledExtension = 'js'
	static processors = [GroovyTemplateProcessor]

	String directiveForLine(String line) {
		return line.find(/\/\/=(.*)/) { fullMatch, directive -> return directive }
	}
}
