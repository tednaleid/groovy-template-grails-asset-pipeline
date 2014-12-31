package asset.pipeline.groovytemplate

import asset.pipeline.AbstractAssetFile
import groovy.transform.CompileStatic

import java.util.regex.Pattern

@CompileStatic
class JavascriptGroovyTemplateAssetFile extends AbstractAssetFile {
	static final String contentType = 'application/javascript'
	static extensions = ['js-gtpl']
	static final String compiledExtension = 'js'
	static processors = [GroovyTemplateProcessor]
    Pattern directivePattern = ~/(?m)^\/\/=(.*)/
}
