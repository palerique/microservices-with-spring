# Social Rating Microservices

A POC to test and learn nice things.

## Nice features TODO:

- Test reactive service
- Add Spring Cloud Config Server and Client
- Some short circuits to the case that some service becomes unavailable
- Add spring test container
- Add Test source folder to Sonarlint build task
- Add some plugin able to format code according to Google style,
  maybe https://github.com/autostyle/autostyle/tree/master/plugin-gradle
- Some way to tackle exceptions between services - Test Camunda Saga
- Add hexagonal architecture
- K8
- Central log and tracing between services - https://spring.io/blog/2016/02/15/distributed-tracing-with-spring-cloud-sleuth-and-spring-cloud-zipkin
- Add a default grafana dashboard that is deployed whenever a instance is created 
    - https://ops.tips/blog/initialize-grafana-with-preconfigured-dashboards/
    - https://grafana.com/grafana/dashboards/4701
    - https://github.com/robsonbittencourt/monitoring-micrometer/tree/master/grafana
- Ensure the code coverage using jacoco

## Nice features already added:

- Add gradle build project as well as conventions to libraries and services
- Consume http requests with JSON in a body;
- Read properties from application properties files
- Send messages to Kafka
- Read messages from Kafka
- Have a service to do calculations
- Cover at least 90% with unit tests
- Log messages (debug and info)
- Persist data on Redis
- Everything is running on docker
- All data are being persisted in Redis
- We can set system properties on .properties files, yaml or environment variables
- Tech stack includes: Java, Spring Boot, Apache Kafka, Redis
- [CI implemented using Github Actions](https://github.com/palerique/microservices-with-spring/actions)
- Quality enforcement during build (Code style with Checkstyle (Google Java Style), code quality
  with PMD and SpotBugs, code coverage % with Jacoco, security and vulnerabilities with OWASP)
- Application gateway
- We can scale the microservices and have many instances of each one
- Service Registry
- Performance test with Gatling
- Docker Compose to start and run everything
- Application monitoring with Micrometrics, Prometheus, Grafana
- Postman collection containing request to schedule people
- Added bash scripts to make tasks easier to be executed
- Added Sonarlint during the build
- Prepared PMD ruleset to v7
- Gradle is building projects in parallel

## System Diagram:

![System Diagram](diagram/ccbt.svg)

## Services Address and Ports

| Service                        | Address + Port                                                     | Observations                |
|--------------------------------|--------------------------------------------------------------------|-----------------------------|
| Consul UI                      | [localhost:8500](http://localhost:8500)                            | Service Registry UI         |
| social-rating-data-collector   | [localhost:80/collector](http://localhost:80/collector/actuator)   | Service I                   |
| social-rating-data-calculator  | [localhost:80/calculator](http://localhost:80/calculator/actuator) | Service II                  |
| App Gateway                    | [localhost:80](http://localhost:80)                                | Application gateway to APIs |
| App Config Server              | [localhost:8888](http://localhost:8888)                            | Application Config Server   |
| Prometheus                     | [localhost:9090](http://localhost:9090)                            | Metrics / Monitoring        |
| Grafana                        | [localhost:3000](http://localhost:3000) - user: admin pwd: grafana | Metrics / Monitoring        |
| Prometheus Pushgateway         | [localhost:9091](http://localhost:9091)                            | Metrics / Monitoring        |
| Redis                          | [localhost:6379](http://localhost:6379)                            | Data structure store        |
| Kafka                          | [localhost:9092](http://localhost:9092)                            | Messaging                   |

## References:

- https://www.nexsoftsys.com/articles/how-to-anatomy-of-spring-cloud-config-work.html
- https://cloud.spring.io/spring-cloud-config/reference/html/#_spring_cloud_config_server
- https://github.com/spring-tips/spring-cloud-config-monitor
- https://www.youtube.com/watch?v=aC_siBP8rx8



