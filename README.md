# Social Rating Microservices

A POC to test and learn nice things.

## Nice features TODO:

- Add gradle build project as well as conventions to libraries and services
- Some way to tackle exceptions between services
- Some short circuits to the case that some service becomes unavailable 
- Add spring test container

## Nice features already added:

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
- [CI implemented using Github Actios](https://github.com/palerique/microservices-with-spring/actions)
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

## System Diagram:

![System Diagram](diagram/ccbt.svg)

## Services Address and Ports

| Service                       | Address + Port                                                              | Observations                 |
|-------------------------------|-----------------------------------------------------------------------------|------------------------------|
| Consul UI                     | [localhost:8500](http://localhost:8500)                                     | Service Registry UI          |
| social-rating-data-collector  | [localhost:80/collector](http://localhost:80/collector/actuator)            | Service I                    |
| social-rating-data-calculator | [localhost:80/calculator](http://localhost:80/calculator/actuator)          | Service II                   |
| App Gateway                   | [localhost:80](http://localhost:80)                                         | Application gateway to APIs  |
| Prometheus                    | [localhost:9090](http://localhost:9090)                                     | Metrics / Monitoring         |
| Grafana                       | [localhost:3000](http://localhost:3000) - user: admin pwd: grafana          | Metrics / Monitoring         |
| Prometheus Pushgateway        | [localhost:9091](http://localhost:9091)                                     | Metrics / Monitoring         |
| Redis                         | [localhost:6379](http://localhost:6379)                                     | Data structure store         |
| Kafka                         | [localhost:9092](http://localhost:9092)                                     | Messaging                    |
