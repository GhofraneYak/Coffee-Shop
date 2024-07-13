package models

case class Item(
                 private var _product: Product,
                 private var _quantity: Int
               ) {
  def getProduct: Product = _product
  def setProduct(product: Product): Unit = _product = product
  def getQuantity: Int = _quantity
  def setQuantity(quantity: Int): Unit = _quantity = quantity
}
