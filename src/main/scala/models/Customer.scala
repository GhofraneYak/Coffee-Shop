package models

case class Customer(private var _id: Long,
                    private var _name: String,
                    private var _email: String
                   ) {
  def getId: Long = _id
  def setId(id: Long): Unit = _id = id
  def getName: String = _name
  def setName(name: String): Unit = _name = name
  def getEmail: String = _email
  def setEmail(email: String): Unit = _email = email
}
