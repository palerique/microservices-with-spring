plugins {
    java
    id("com.github.spotbugs")
    checkstyle
    id("org.owasp.dependencycheck")
    pmd
    jacoco
}

//group = "br.com.palerique"
//version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

//configurations {
//    compileOnly {
//        extendsFrom(configurations.annotationProcessor.get())
//    }
//}


repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.projectlombok:lombok:1.18.22")
    implementation("com.github.spotbugs:spotbugs-annotations:4.5.2")
}

testing {
    suites {
//         Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
//             Use JUnit Jupiter test framework
            useJUnitJupiter("5.7.2")
        }
    }
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions {
//        freeCompilerArgs = listOf("-Xjsr305=strict")
//        jvmTarget = "17"
//    }
//}
//
//tasks.withType<Test> {
//    useJUnitPlatform()
//}

spotbugs {
    effort.set(com.github.spotbugs.snom.Effort.MAX)
    reportLevel.set(com.github.spotbugs.snom.Confidence.LOW)
    ignoreFailures.set(false)
    showProgress.set(true)
    showStackTraces.set(true)
}

checkstyle {
    toolVersion = "8.42"
//    ignoreFailures.set(false)
//    maxErrors.set(0)
//    maxWarnings.set(0)
//    configDirectory.set(file("${project.rootDir}/../config/checkstyle"))
}

//check.dependsOn dependencyCheckAnalyze
//check.dependsOn jacocoTestCoverageVerification
//check.dependsOn jacocoTestReport
//
//dependencyCheck {
//    failBuildOnCVSS.set(0)
//    suppressionFile.set("${project.rootDir}/../config/owasp/suppressions.xml")
//}

pmd {
//    consoleOutput = true
    toolVersion = "6.34.0"
//    ruleSets = ["${project.rootDir}/../config/pmd/ruleset.xml"]
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
