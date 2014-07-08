eventAssetPrecompileStart = { assetConfig ->
  assetConfig.specs << 'asset.pipeline.groovytemplate.JavascriptGroovyTemplateAssetFile'
  assetConfig.specs << 'asset.pipeline.groovytemplate.StylesheetGroovyTemplateAssetFile'
  asset.pipeline.JsAssetFile.processors << asset.pipeline.groovytemplate.JavascriptUrlAwareProcessor 
}
