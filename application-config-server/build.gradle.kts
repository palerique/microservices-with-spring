plugins {
    id("br.com.palerique.microservices.java-application-conventions")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
    implementation("org.springframework.cloud:spring-cloud-config-server")
}
