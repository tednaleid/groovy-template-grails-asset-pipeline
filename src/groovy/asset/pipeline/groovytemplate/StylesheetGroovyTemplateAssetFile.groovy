package asset.pipeline.groovytemplate

import asset.pipeline.AbstractAssetFile
import groovy.transform.CompileStatic

import java.util.regex.Pattern

@CompileStatic
class StylesheetGroovyTemplateAssetFile extends AbstractAssetFile {
	static final String contentType = 'text/css'
	static extensions = ['css-gtpl']
	static final String compiledExtension = 'css'
	static processors = [GroovyTemplateProcessor]
    Pattern directivePattern = ~/(?m)\*=(.*)/
}
