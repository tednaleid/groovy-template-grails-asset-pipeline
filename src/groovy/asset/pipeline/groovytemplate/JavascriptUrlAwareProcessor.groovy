package asset.pipeline.groovytemplate

import asset.pipeline.AbstractProcessor
import asset.pipeline.AssetCompiler
import asset.pipeline.AssetFile
import asset.pipeline.AssetHelper
import groovy.util.logging.Log4j

@Log4j
class JavascriptUrlAwareProcessor extends AbstractProcessor {

    JavascriptUrlAwareProcessor(AssetCompiler compiler) {
        super(compiler)
    }

    @Override
    String process(String inputText, AssetFile assetFile) {

        if (!this.precompiler) return inputText

        return inputText.replaceAll(/(['"]assets\/)([^'"]*\.html)(['"])/) { String fullMatch, String assetPrefix, String assetFileName, String lastQuote ->
            String digestedAssetFileName = getDigestedAssetFileName(assetFileName)
            if (digestedAssetFileName) {
                return "${assetPrefix}${digestedAssetFileName}${lastQuote}"
            } else {
                return fullMatch
            }
        }
    }

    protected static String getDigestedAssetFileName(String assetFileName) {
        def assetFile = AssetHelper.fileForFullName(assetFileName)

        if (assetFile) {
            List<String> pathPrefixPieces = getPathPrefixPieces(assetFileName)
            def extension = AssetHelper.extensionFromURI(assetFile.getName())
            def fileName  = AssetHelper.nameWithoutExtension(assetFile.getName())
            def digestName = AssetHelper.getByteDigest(assetFile.bytes)
            String digestedAssetFileName = "${fileName}-${digestName}.${extension}"
            return (pathPrefixPieces << digestedAssetFileName).join("/")
        } else {
            return assetFileName
        }

    }

    protected static List<String> getPathPrefixPieces(String assetFileName) {
        List<String> fileNamePieces = (assetFileName ?: "").split("/")
        return fileNamePieces.take(fileNamePieces.size() - 1)
    }
}
