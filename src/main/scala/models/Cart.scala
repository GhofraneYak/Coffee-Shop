package models

case class Cart(
                 var id: Long,
                 var customerId: Long,
                 var items: List[Item],
                 var total: Double
               )
