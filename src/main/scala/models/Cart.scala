package models

case class Cart(
                 private var _id: Long,
                 private var _customerId: Long,
                 private var _items: List[Item],
                 private var _total: Double
               ) {
  def getId: Long = _id
  def setId(id: Long): Unit = _id = id
  def getCustomerId: Long = _customerId
  def setCustomerId(customerId: Long): Unit = _customerId = customerId
  def getItems: List[Item] = _items
  def setItems(items: List[Item]): Unit = _items = items
  def getTotal: Double = _total
  def setTotal(total: Double): Unit = _total = total
}
