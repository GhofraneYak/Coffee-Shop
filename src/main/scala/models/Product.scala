package models

case class Product(
                    var id: Long,
                    var name: String,
                    var description: String,
                    var price: Double,
                    var stock: Int
                  )
