plugins {
    id("org.springframework.boot")

    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = true
jar.enabled = false

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.springframework.boot:spring-boot-starter-web")

    /** GRPC */
    implementation("link.jfire:simplerpc:1.0")
    implementation("io.github.HuChen-dot:simplerpc-spring-boot-starter:1.6")
//    implementation("net.devh:grpc-server-spring-boot-starter:2.13.1.RELEASE")
    implementation("net.devh:grpc-server-spring-boot-starter:2.15.0.RELEASE")
    implementation(files("libs/grpc-if-0.0.1-SNAPSHOT.jar"))
}
