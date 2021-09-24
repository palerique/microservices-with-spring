package br.com.palerique.socialratingcollector

import io.gatling.core.Predef._
import io.gatling.core.feeder.FeederBuilderBase
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class CollectorSimulation extends Simulation {

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("http://localhost")
    .acceptHeader("*/*")
    .contentTypeHeader("application/json")

  val jsonUrlFeeder: FeederBuilderBase[Any]#F = jsonFile("people.json").random

  val allOperationsScn: ScenarioBuilder = scenario("CollectorSimulation")
    .feed(jsonUrlFeeder)
    .exec(http("schedulePerson")
      .post("/collector/people/")
      .body(ElFileBody("person.json")).asJson
      .check(status.is(201))
      .check(jsonPath("$.message")
        .is("Person successfully scheduled to be processed"))
      .check(jsonPath("$.data").notNull))

  setUp(
    allOperationsScn.inject(
      //      atOnceUsers(10)
      constantConcurrentUsers(10).during(10.seconds),
      rampConcurrentUsers(10).to(20).during(10.seconds)
    ),
  ).protocols(httpProtocol)
}
