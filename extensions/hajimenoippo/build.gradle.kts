plugins {
    id("tachiyomi.extension")
}

setupTachiyomiExtensionConfiguration {
    namespaceIdentifier = "id"
    extName = "Hajime no Ippo (Mandiri)"
    pkgNameSuffix = "hajimenoippo"
    extClass = ".HajimeNoIppo"
    extVersionCode = 1
    isNsfw = false
}
