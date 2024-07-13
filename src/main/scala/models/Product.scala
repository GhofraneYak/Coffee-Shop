package models

case class Product(
                    private var _id: Long,
                    private var _name: String,
                    private var _description: String,
                    private var _price: Double,
                    private var _stock: Int
                  ) {
  // Getters and setters
  def getId: Long = _id
  def setId(id: Long): Unit = _id = id
  def getName: String = _name
  def setName(name: String): Unit = _name = name
  def getDescription: String = _description
  def setDescription(description: String): Unit = _description = description
  def getPrice: Double = _price
  def setPrice(price: Double): Unit = _price = price
  def getStock: Int = _stock
  def setStock(stock: Int): Unit = _stock = stock
  def addStock(stockToAdd: Int): Unit = _stock = _stock + stockToAdd
}
