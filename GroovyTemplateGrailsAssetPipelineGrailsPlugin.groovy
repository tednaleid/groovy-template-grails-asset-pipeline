import asset.pipeline.AssetHelper
import asset.pipeline.JsAssetFile
import asset.pipeline.groovytemplate.JavascriptGroovyTemplateAssetFile
import asset.pipeline.groovytemplate.JavascriptUrlAwareProcessor
import asset.pipeline.groovytemplate.StylesheetGroovyTemplateAssetFile

class GroovyTemplateGrailsAssetPipelineGrailsPlugin {
    // the plugin version
    def version = "0.4"

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.3 > *"

    def title = "Groovy Template Grails Asset Pipeline Plugin"

    def author = "Ted Naleid"
    def authorEmail = "contact@naleid.com"

    def description = 'Provides Groovy Template support (including Grails Config access) to asset pipeline js/css files'
    def documentation = "http://github.com/tednaleid/groovy-template-grails-asset-pipeline"

    def license = "APACHE"

    def organization = [ name: "Naleid Consulting", url: "http://naleid.com/" ]
    def issueManagement = [ system: "GITHUB", url: "http://github.com/tednaleid/groovy-template-grails-asset-pipeline/issues" ]
    def scm = [ url: "http://github.com/tednaleid/groovy-template-grails-asset-pipeline" ]

    def doWithDynamicMethods = { ctx ->
        AssetHelper.assetSpecs << JavascriptGroovyTemplateAssetFile
        AssetHelper.assetSpecs << StylesheetGroovyTemplateAssetFile
        JsAssetFile.processors << JavascriptUrlAwareProcessor
    }
}
