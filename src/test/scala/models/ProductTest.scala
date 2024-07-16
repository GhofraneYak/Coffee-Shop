package models

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ProductTest extends AnyWordSpec with Matchers {

  "A Product" should {
    "be instantiated with correct values" in {
      val product = Product(1, "Tim Hortons Decaf", "Tim Hortons Decaffeinated Coffee 350g", 3.5, 10)
      product.getId shouldBe 1
      product.getName shouldBe "Tim Hortons Decaf"
      product.getDescription shouldBe "Tim Hortons Decaffeinated Coffee 350g"
      product.getPrice shouldBe 3.5
      product.getStock shouldBe 10
    }

    "have correct equality behavior" in {
      val product1 = Product(1, "Tim Hortons Decaf", "Tim Hortons Decaffeinated Coffee 350g", 3.5, 10)
      val product2 = Product(1, "Tim Hortons Decaf", "Tim Hortons Decaffeinated Coffee 350g", 3.5, 10)
      val product3 = Product(3, "Tim Hortons Regular", "Tim Hortons Regular Coffee 350g", 3, 10)

      product1 shouldEqual product2
      product1 should not equal product3
    }

    "allow updates to fields" in {
      val product = Product(1, "Tim Hortons Decaf", "Tim Hortons Decaffeinated Coffee 350g", 3.5, 10)
      val updatedProduct = product.copy(_price = 4.00)

      updatedProduct.getId shouldBe 1
      updatedProduct.getName shouldBe "Tim Hortons Decaf"
      updatedProduct.getPrice shouldBe 4.00
    }
  }
}
