import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("kapt")
}

group = "com.mooop"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<Jar>{
    enabled = false
}

tasks.withType<BootJar>{
    enabled = true
}

extra["springCloudVersion"] = "2023.0.3"

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.springframework.boot:spring-boot-starter-web")
    /** Config Client */
    implementation("org.springframework.cloud:spring-cloud-starter-config")

    testImplementation(kotlin("test"))
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}