plugins {
    id("org.springframework.boot")
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = true
jar.enabled = false

dependencies {
    implementation(project(":core"))

    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.springframework.boot:spring-boot-starter-web")

    /** JPA */
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    /** MYSQL */
    implementation("mysql:mysql-connector-java:8.0.11")
}
