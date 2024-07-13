package models

case class Order(
                  var id: Long,
                  var customerId: Long,
                  var items: List[Item],
                  var total: Double
                )
