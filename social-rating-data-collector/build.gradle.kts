plugins {
    id("br.com.palerique.microservices.java-application-conventions")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("org.apache.kafka:kafka-clients:2.6.2")
    testImplementation("org.springframework.kafka:spring-kafka-test")
    implementation("net.jcip:jcip-annotations:1.0")
}
