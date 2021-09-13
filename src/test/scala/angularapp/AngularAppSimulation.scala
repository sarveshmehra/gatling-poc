package angularapp

import gatlingdemostore.pageobjects._

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

import scala.util.Random

class AngularAppSimulation extends Simulation{
  val domain = "web.stage.aws.blue.bisnode.net/angular-with-jest"

  val httpProtocol = http
    .baseUrl("https://" + domain)


  val initSession = exec(flushCookieJar)

  object AngularPages {
    def homepage = {
      exec(http("Load Home Page")
        .get("/")
        .check(status.in(200))
        .check(substring("Tour of Heroes")))
    }
  }
    val scn = scenario("DemostoreSimulation")
      .exec(initSession)
      .exec(AngularPages.homepage)
      .pause(2)


    setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
      .assertions(forAll.failedRequests.percent.lte(5))
}
