package handlers

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.server.Route
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import controllers.*
import models.*

import scala.concurrent.ExecutionContextExecutor

object ProductHandler {
  implicit val system: ActorSystem = ActorSystem("product-system")
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  // Initialize Jackson ObjectMapper
  val mapper = new ObjectMapper().registerModule(DefaultScalaModule)

  // Define product routes
  val routes: Route =
    pathPrefix("products") {
      concat(
        pathEnd {
          concat(
            get {
              val products = ProductController.getProducts
              complete(mapper.writeValueAsString(products))
            },
            post {
              entity(as[String]) { productJson =>
                val product = mapper.readValue(productJson, classOf[Product])
                ProductController.addProduct(product)
                complete("Product added")
              }
            }
          )
        }
      )
    }
}
