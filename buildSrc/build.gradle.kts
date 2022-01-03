plugins {
    `kotlin-dsl`
//    java
//    id("org.springframework.boot") version "2.6.2"
//    id("io.spring.dependency-management") version "1.0.11.RELEASE"
//    kotlin("jvm") version "1.6.10"
//    kotlin("plugin.spring") version "1.6.10"
//    id("com.github.spotbugs") version ("4.7.0")
//    id("org.owasp.dependencycheck") version ("6.3.1")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap/")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.6.2")
    implementation("io.spring.gradle:dependency-management-plugin:1.0.11.RELEASE")
    implementation("com.github.spotbugs.snom:spotbugs-gradle-plugin:5.0.3")
    implementation("org.owasp:dependency-check-gradle:6.5.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
    implementation("org.jetbrains.kotlin:kotlin-allopen")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.4.30")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.18.1")
}
