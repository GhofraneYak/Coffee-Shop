package controllers

import models.Product
import org.json4s.DefaultFormats

object ProductController {
  implicit val formats: DefaultFormats.type = DefaultFormats
  private var products: List[Product] = List()
  /**
   * Get actual products
   *
   * @return
   */
  def getProducts: List[Product] = {
    products
  }

  /**
   * Get product by id
   *
   * @return
   */
  def getProductById(id: Long): Option[Product] = {
    products.findLast(_.getId == id)
  }

  /**
   * Add product to the list of actual products
   *
   * @param product product
   * @return
   */
  def addProduct(product: Product): Product = {
    products = products :+ product
    product
  }

  /**
   * Update product attributes
   *
   * @param id             product id
   * @param updatedProduct new product
   * @return
   */
  def updateProduct(updatedProduct: Product): Option[Product] = {
    def id = updatedProduct.getId
    products = products.map { product =>
      if (product.getId == id) {
        CartController.updateProductInCarts(updatedProduct)
        updatedProduct
      } else product
    }
    products.find(_.getId == id)
  }

  /**
   * Delete product from the list of actual products
   *
   * @param id product id
   * @return
   */
  def deleteProduct(id: Long): Option[Product] = {
    val productOpt = products.find(_.getId == id)
    products = products.filterNot(_.getId == id)
    productOpt
  }

  /**
   * Update product quantity
   *
   * @param id       id for which we want to update stock
   * @param quantity quantity to add (to subtract use -)
   * @return
   */
  def updateStock(id: Long, quantity: Int): Option[Product] = {
    products = products.map { product =>
      if (product.getId == id) {
        product.addStock(quantity)
        product
      } else product
    }
    products.find(_.getId == id)
  }
}
