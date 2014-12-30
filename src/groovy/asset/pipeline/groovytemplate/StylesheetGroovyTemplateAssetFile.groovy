package asset.pipeline.groovytemplate

import asset.pipeline.AbstractAssetFile
import groovy.transform.CompileStatic

@CompileStatic
class StylesheetGroovyTemplateAssetFile extends AbstractAssetFile {
	static final String contentType = 'text/css'
	static extensions = ['css-gtpl']
	static final String compiledExtension = 'css'
	static processors = [GroovyTemplateProcessor]

	String directiveForLine(String line) {
		line.find(/\*=(.*)/) { fullMatch, directive -> return directive }
	}
}
