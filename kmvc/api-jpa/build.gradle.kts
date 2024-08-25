import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

//buildscript {
//    ext {
//        queryDslVersion = "5.0.0"
//    }
//}

plugins {
    id("org.springframework.boot")
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    kotlin("kapt") version "1.6.10"

//    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
var queryDslVersion = "5.0.0"

// Q督析 持失 井稽
sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
    kotlin.srcDir("$buildDir/generated/source/kapt/main")
}

repositories {
    mavenCentral()
}


val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = true
jar.enabled = false

dependencies {
    implementation(kotlin("stdlib"))

//    implementation(project(":core"))

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    implementation("org.springframework.boot:spring-boot-starter-web")

    /** JPA */
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    /** MYSQL */
    implementation("mysql:mysql-connector-java:8.0.11")

    /** QueryDSL */
//    implementation("com.querydsl:querydsl-jpa:${queryDslVersion}")
//    implementation("com.querydsl:querydsl-apt:${queryDslVersion}")
    api("com.querydsl:querydsl-jpa:")
    kapt(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa")
}

//def querydslDir = "$buildDir/generated/querydsl"
//
//querydsl {
//    jpa = true
//    querydslSourcesDir = querydslDir
//}
//sourceSets {
//    main.java.srcDir querydslDir
//}
//configurations {
//    querydsl.extendsFrom compileClasspath
//}
//compileQuerydsl {
//    options.annotationProcessorPath = configurations.querydsl
//}
