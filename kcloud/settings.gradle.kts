plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "kcloud"
include("config-server")
include("morder")
include("edge-server")
include("mprod")
