package controllers

import models.{Cart, Item, Order, Product}

object CartController {
  private var carts: List[Cart] = List()

  /**
   * Get customer's cart
   *
   * @param customerId customer id
   * @return
   */
  def getCart(customerId: Long): Option[Cart] = {
    carts.find(_.getCustomerId == customerId)
  }

  /**
   * Add item to cart, if it already exists update its quantity
   *
   * @param customerId customer id
   * @param item       item to add
   * @return
   */
  def addToCart(customerId: Long, item: Item): Cart = {
    val cartOpt = carts.find(_.getCustomerId == customerId)
    cartOpt match {
      case Some(cart) =>
        val existingItemOpt = cart.getItems.find(_.getProduct.getId == item.getProduct.getId)
        existingItemOpt match {
          case Some(existingItem) =>
            existingItem.setQuantity(existingItem.getQuantity + item.getQuantity)
          case None =>
            cart.setItems(cart.getItems :+ item)
        }
        cart.setTotal(cart.getItems.map(i => i.getProduct.getPrice * i.getQuantity).sum)
        cart
      case None =>
        val newCart = Cart(carts.size + 1, customerId, List(item), item.getProduct.getPrice * item.getQuantity)
        carts = carts :+ newCart
        newCart
    }
  }

  /**
   * Remove a product from cart (reduce quantity by 1)
   *
   * @param customerId customer id
   * @param productId  product id
   * @return
   */
  def removeFromCart(customerId: Long, productId: Long, quantity: Int): Option[Cart] = {
    val cartOpt = carts.find(_.getCustomerId == customerId)
    cartOpt match {
      case Some(cart) =>
        val existingItemOpt = cart.getItems.find(_.getProduct.getId == productId)
        existingItemOpt match {
          case Some(existingItem) =>
            val newQuantity = existingItem.getQuantity - quantity
            if (newQuantity > 0) {
              existingItem.setQuantity(newQuantity)
            } else {
              cart.setItems(cart.getItems.filterNot(_.getProduct.getId == productId))
            }
            cart.setTotal(cart.getItems.map(i => i.getProduct.getPrice * i.getQuantity).sum)
            Some(cart)
          case None => None
        }
      case None => None
    }
  }

  /**
   * Transform cart to order
   *
   * @param customerId customer id
   * @return
   */
  def checkout(customerId: Long): Option[Order] = {
    val cartOpt = carts.find(_.getCustomerId == customerId)
    cartOpt match {
      case Some(cart) =>
        val orderItems = cart.getItems.map(item => Item(item.getProduct, item.getQuantity))
        val order = Order(OrderController.getOrders.size + 1, customerId, orderItems, cart.getTotal)
        OrderController.addOrder(order)
        carts = carts.filterNot(_.getCustomerId == customerId)
        Some(order)
      case None => None
    }
  }

  /**
   * Update product information in all carts and update price accordingly
   *
   * @param product product id
   */
  def updateProductInCarts(product: Product): Unit = {
    carts.foreach { cart =>
      cart.getItems.foreach { item =>
        if (item.getProduct.getId == product.getId) {
          item.setProduct(product)
        }
      }
      cart.setTotal(cart.getItems.map(i => i.getProduct.getPrice * i.getQuantity).sum)
    }
  }
}
