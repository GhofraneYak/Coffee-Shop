package controllers

import models.Order
import org.json4s.DefaultFormats

object OrderController {
  implicit val formats: DefaultFormats.type = DefaultFormats
  private var orders: List[Order] = List()
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

  /**
   * Delete order
   *
   * @param id order id
   * @return
   */
  def deleteOrder(id: Long): Option[Order] = {
    val orderOpt = orders.find(_.getId == id)
    orders = orders.filterNot(_.getId == id)
    orderOpt
  }
}
