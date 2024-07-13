package controllers

import models.*
import org.json4s.DefaultFormats
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write

object OrderController {
  private var orders: List[Order] = List()

  implicit val formats: DefaultFormats.type = DefaultFormats

  /**
   * Get all orders
   *
   * @return
   */
  def getOrders: List[Order] = {
    orders
  }

  /**
   * Add an order
   *
   * @param order order to create
   * @return
   */
  def addOrder(order: Order): Order = {
    orders = orders :+ order
    order
  }
}
