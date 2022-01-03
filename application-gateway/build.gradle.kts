plugins {
    id("br.com.palerique.microservices.java-application-conventions")
}

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
}
