package controllers

import models.*
import org.json4s.DefaultFormats
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write

object ProductController {
  private var products: List[Product] = List()

  implicit val formats: DefaultFormats.type = DefaultFormats

  /**
   * Get actual products
   *
   * @return
   */
  def getProducts: String = {
    write(products)
  }

  /**
   * Add product to the list of actual products
   *
   * @param json product attributes
   * @return
   */
  def addProduct(json: String): String = {
    val product = Serialization.read[Product](json)
    products = (products :+ product).distinct
    write(product)
  }

  /**
   * Update product attributes
   *
   * @param id   product id
   * @param json new product attributes
   * @return
   */
  def updateProduct(id: Long, json: String): String = {
    val updatedProduct = Serialization.read[Product](json)
    products = products.map { product =>
      //TODO potential problem if updated product doesn't have all attributes needed
      if (product.id == id) updatedProduct else product
    }
    write(updatedProduct)
  }

  /**
   * Delete product from the list of actual products
   *
   * @param id product id
   * @return
   */
  def deleteProduct(id: Long): String = {
    val productOpt = products.find(_.id == id)
    products = products.filterNot(_.id == id)
    write(productOpt.getOrElse("{}"))
  }

  /**
   * Update product quantity
   *
   * @param id       id for which we want to update stock
   * @param quantity quantity to add (to subtract use -)
   * @return
   */
  def updateStock(id: Long, quantity: Int): String = {
    products = products.map { product =>
      if (product.id == id) {
        product.stock += quantity
        product
      } else product
    }
    write(products.find(_.id == id).getOrElse("{}"))
  }
}
