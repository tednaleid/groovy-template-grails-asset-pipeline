package asset.pipeline.groovytemplate

import asset.pipeline.AbstractProcessor
import asset.pipeline.AssetCompiler
import asset.pipeline.AssetFile
import grails.util.Holders
import groovy.text.SimpleTemplateEngine
import groovy.util.logging.Log4j

@Log4j
class GroovyTemplateProcessor extends AbstractProcessor {
    def config
    def engine

    def binding

    GroovyTemplateProcessor(AssetCompiler compiler) {
        super(compiler)
        def grailsApplication = Holders.grailsApplication

        this.engine = new SimpleTemplateEngine(this.class.classLoader)

        this.binding = [
                grailsApplication: grailsApplication,
                config: grailsApplication.config
        ]
    }

    String process(String inputText, AssetFile assetFile) {
        log.debug("Processing assetFile: ${assetFile.name}")
        StringWriter stringWriter = new StringWriter()
        try {
            engine.createTemplate(inputText).make(binding).writeTo(stringWriter)
            return stringWriter.toString()
        } catch (Exception e) {
            log.error("Error compiling groovy template asset file", e)
            throw e
        } finally {
            stringWriter.close()
        }
    }
}
