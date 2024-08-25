
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

bootJar.enabled = false
jar.enabled = true


dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.2")
    implementation("io.jsonwebtoken:jjwt-impl:0.11.2")

    implementation("org.apache.httpcomponents:httpclient:4.5.13")

    implementation("org.springframework.boot:spring-boot-starter-web")

    /** JPA */
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    /** MYSQL */
    implementation("mysql:mysql-connector-java:8.0.11")

    /** AWS */
    implementation("org.springframework.cloud:spring-cloud-starter-aws:2.2.1.RELEASE")

    /** file upload */
    implementation("commons-io:commons-io:2.6")
    implementation("commons-fileupload:commons-fileupload:1.4")

    /** AOP */
    implementation("org.springframework.boot:spring-boot-starter-aop:2.6.6")

    implementation("org.springframework.boot:spring-boot-configuration-processor")

//    kapt("org.springframework.boot:spring-boot-configuration-processor")
//    compileOnly("org.springframework.boot:spring-boot-configuration-processor")
}
