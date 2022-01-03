import com.github.spotbugs.snom.Confidence
import com.github.spotbugs.snom.Effort
import com.github.spotbugs.snom.SpotBugsTask

plugins {
    java
    pmd
    id("com.github.spotbugs")
//    jacoco
//    checkstyle
//    id("org.owasp.dependencycheck")
}

//group = "br.com.palerique"
//version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}


repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.22")
    implementation("com.github.spotbugs:spotbugs-annotations:4.5.2")
    annotationProcessor("org.projectlombok:lombok:1.18.22")
}

//testing {
//    suites {
////         Configure the built-in test suite
//        val test by getting(JvmTestSuite::class) {
////             Use JUnit Jupiter test framework
//            useJUnitJupiter("5.7.2")
//        }
//    }
//}

//tasks.withType<KotlinCompile> {
//    kotlinOptions {
//        freeCompilerArgs = listOf("-Xjsr305=strict")
//        jvmTarget = "17"
//    }
//}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<SpotBugsTask>().configureEach {
    ignoreFailures = false
    effort.set(Effort.MAX)
    reportLevel.set(Confidence.LOW)
    showProgress.set(true)
    showStackTraces = true
    reports.maybeCreate("xml").isEnabled = false
    reports.maybeCreate("html").isEnabled = true
}

//configure<CheckstyleExtension> {
//    isIgnoreFailures = false
//    maxErrors = 0
//    maxWarnings = 0
//    configDirectory.set(file("${project.rootDir}/config/checkstyle"))
//}

//checkstyle {
//    toolVersion = "8.42"
////    ignoreFailures.set(false)
////    ignoreFailures = false
////    maxErrors.set(0)
////    maxWarnings.set(0)
////    configDirectory.set(file("${project.rootDir}/../config/checkstyle"))
//}

//tasks.check{
////    dependsOn(DependencyCheckAnalyze)
//    dependsOn(JacocoCoverageVerification)
//}

//check.dependsOn dependencyCheckAnalyze
//check.dependsOn jacocoTestCoverageVerification
//check.dependsOn jacocoTestReport
//
//dependencyCheck {
//    failBuildOnCVSS.set(0)
//    suppressionFile.set("${project.rootDir}/../config/owasp/suppressions.xml")
//}

pmd {
    isConsoleOutput = true
    toolVersion = "6.34.0"
    rulesMinimumPriority.set(5)
    ruleSets = listOf("${project.rootDir}/config/pmd/ruleset.xml")
}

//jacocoTestCoverageVerification {
//    violationRules {
//        rule {
//            limit {
//                minimum.set(0.9)
//            }
//        }
//    }
//}


// A resolvable configuration to collect source code
//val sourcesPath: Configuration by configurations.creating {
//    isVisible = false
//    isCanBeResolved = true
//    isCanBeConsumed = false
//    extendsFrom(configurations.implementation.get())
//    attributes {
//        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
//        attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.DOCUMENTATION))
//        attribute(DocsType.DOCS_TYPE_ATTRIBUTE, objects.named("source-folders"))
//    }
//}
//
//// A resolvable configuration to collect JaCoCo coverage data
//val coverageDataPath: Configuration by configurations.creating {
//    isVisible = false
//    isCanBeResolved = true
//    isCanBeConsumed = false
//    extendsFrom(configurations.implementation.get())
//    attributes {
//        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
//        attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.DOCUMENTATION))
//        attribute(DocsType.DOCS_TYPE_ATTRIBUTE, objects.named("jacoco-coverage-data"))
//    }
//}
//
//// Task to gather code coverage from multiple subprojects
//val codeCoverageReport by tasks.registering(JacocoReport::class) {
//    additionalClassDirs(configurations.runtimeClasspath.get())
//    additionalSourceDirs(sourcesPath.incoming.artifactView { lenient(true) }.files)
//    executionData(coverageDataPath.incoming.artifactView { lenient(true) }.files.filter { it.exists() })
//
//    reports {
//        // xml is usually used to integrate code coverage with
//        // other tools like SonarQube, Coveralls or Codecov
//        xml.required.set(true)
//
//        // HTML reports can be used to see code coverage
//        // without any external tools
//        html.required.set(true)
//    }
//}
//
//// Make JaCoCo report generation part of the 'check' lifecycle phase
//tasks.check {
//    dependsOn(codeCoverageReport)
//}
