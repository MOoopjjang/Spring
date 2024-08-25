import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


buildscript{
	repositories {
		mavenCentral()
	}
}

plugins {
	kotlin("jvm") version "1.9.24" apply false
	kotlin("plugin.spring") version "1.9.24" apply false
	kotlin("kapt") version "1.9.24" apply false
	id("org.springframework.boot") version "3.2.8" apply false
	id("io.spring.dependency-management") version "1.1.6" apply false
}


allprojects{
	group = "com.mooop"
	version = "0.0.1-SNAPSHOT"

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs += "-Xjsr305=strict"
			jvmTarget = "17"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

subprojects {
	repositories {
		mavenCentral()
	}

	apply {
		plugin("io.spring.dependency-management")
	}
}

//group = "com.mooop"
//version = "0.0.1-SNAPSHOT"
//
//java {
//	toolchain {
//		languageVersion = JavaLanguageVersion.of(17)
//	}
//}
//
//repositories {
//	mavenCentral()
//}
//
//extra["springCloudVersion"] = "2023.0.3"
//
//dependencies {
//	implementation("org.jetbrains.kotlin:kotlin-reflect")
//	implementation("org.springframework.cloud:spring-cloud-config-server")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
//	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
//}
//
//dependencyManagement {
//	imports {
//		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//	}
//}
//
//kotlin {
//	compilerOptions {
//		freeCompilerArgs.addAll("-Xjsr305=strict")
//	}
//}
//
//tasks.withType<Test> {
//	useJUnitPlatform()
//}
