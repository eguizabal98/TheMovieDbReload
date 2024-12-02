//
// all the dependencies are being defined in the versions
// catalog inside the libs.versions.toml file
//
dependencyResolutionManagement {
    versionCatalogs {
        // define custom name to access version catalog: "libs"
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "TheMovieDbReload"
