package handlers

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.PathMatchers.LongNumber
import akka.http.scaladsl.server.Route
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import controllers.ProductController
import models.Product

import scala.concurrent.ExecutionContextExecutor

object ProductHandler {
  implicit val system: ActorSystem = ActorSystem("product-system")
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  // Initialize Jackson ObjectMapper
  val mapper = new ObjectMapper().registerModule(DefaultScalaModule)

  // Define product routes
  val routes: Route = concat(
    pathPrefix("products") {
      concat(
        // Get all products
        pathEnd {
          concat(
            get {
              val products = ProductController.getProducts
              complete(mapper.writeValueAsString(products))
            },
            // Add a product
            post {
              entity(as[String]) { productJson =>
                val product = mapper.readValue(productJson, classOf[Product])
                ProductController.addProduct(product)
                complete("Product added")
              }
            }
          )
        },
        // Get a product by id
        path(LongNumber) { id =>
          get {
            def product = ProductController.getProductById(id)
            product match {
              case Some(x) => complete(mapper.writeValueAsString(x))
              case None => complete("Product not found")
            }
          }
        },
        path("update") {
          put {
            entity(as[String]) { productJson =>
              val product = mapper.readValue(productJson, classOf[Product])
              def updatedProduct = ProductController.updateProduct(product)
              updatedProduct match {
                case Some(x) => complete("Valued updated")
                case None => complete("Product could not be updated")
              }
            }
          }
        }
      )
    }
  )
}
