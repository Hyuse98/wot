rootProject.name = "wot"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven {
            name = "Adoptium"
            url = uri("https://api.adoptium.net/v3/binary/version")
        }
    }
}