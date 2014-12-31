package asset.pipeline.groovytemplate

import asset.pipeline.AbstractAssetFile
import groovy.transform.CompileStatic

import java.util.regex.Pattern

@CompileStatic
class JavascriptGroovyTemplateAssetFile extends AbstractAssetFile {
    static final List<String> contentType = ['application/javascript', 'application/x-javascript','text/javascript']
    static List<String> extensions = ['js-gtpl']
    static String compiledExtension = 'js'
    static processors = [GroovyTemplateProcessor]

    Pattern directivePattern = ~/(?m)^\/\/=(.*)/
}
