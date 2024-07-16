package controllers

import models.Customer

object CustomerController {
  private var customers: List[Customer] = List()

  /**
   * Get actual customers
   *
   * @return
   */
  def getCustomers: List[Customer] = {
    customers
  }

  /**
   * Add a customer to the actual list of customers
   *
   * @param customer customer to add
   * @return
   */
  def addCustomer(customer: Customer): Customer = {
    customers = customers :+ customer
    customer
  }
}
