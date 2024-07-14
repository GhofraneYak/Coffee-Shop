import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.server.Route
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import handlers.*

import scala.concurrent.ExecutionContextExecutor

object Main {
  implicit val system: ActorSystem = ActorSystem("product-system")
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  // Initialize Jackson ObjectMapper
  val mapper = new ObjectMapper().registerModule(DefaultScalaModule)



  def main(args: Array[String]): Unit = {
    val routes: Route = concat(
      ProductHandler.routes
      // Add more handlers here if needed
    )

    val bindingFuture = Http().newServerAt("localhost", 8080).bind(routes)
    println(s"Server online at http://localhost:8080/")
  }
}
