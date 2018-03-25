package simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class LoadSimulation extends Simulation {

  val targetUrl = System.getProperty("TARGET_URL")
  val simUsers = System.getProperty("SIM_USERS").toInt

  val myScenario = scenario("Webflux Demo").exec(
    repeat(30) {
      exec(
        http("request_1").get(targetUrl)
      ).pause(1 second, 2 seconds)
    }
  )
  setUp(myScenario.inject(rampUsers(simUsers).over(30 seconds)))
}
