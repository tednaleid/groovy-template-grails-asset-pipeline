eventAssetPrecompileStart = { assetConfig ->
  assetConfig.specs << 'asset.pipeline.groovytemplate.JavascriptGroovyTemplateAssetFile'
  assetConfig.specs << 'asset.pipeline.groovytemplate.StylesheetGroovyTemplateAssetFile'
}
