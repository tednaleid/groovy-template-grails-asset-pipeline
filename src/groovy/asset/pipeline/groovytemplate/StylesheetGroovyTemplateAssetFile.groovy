package asset.pipeline.groovytemplate

import asset.pipeline.AbstractAssetFile
import asset.pipeline.Processor
import groovy.transform.CompileStatic

import java.util.regex.Pattern

@CompileStatic
class StylesheetGroovyTemplateAssetFile extends AbstractAssetFile {

    static final List<String> contentType = ['text/css']
    static List<String> extensions = ['css-gtpl']
    static String compiledExtension = 'css'
    static List<Class<Processor>> processors = [GroovyTemplateProcessor]

    Pattern directivePattern = ~/(?m)\*=(.*)/
}
