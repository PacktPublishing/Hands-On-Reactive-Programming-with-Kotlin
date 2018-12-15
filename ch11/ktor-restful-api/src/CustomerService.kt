package com.packtpub.hands.on.reactive.kotlin.chapter11

class CustomerService {
  companion object {
    val customers = hashMapOf(
        1 to Customer("Peter", "Parker"),
        2 to Customer("Steve", "Rogers"),
        3 to Customer("Red", "Richards")
    )
  }
  fun getCustomer(id: Int) = customers[id]!!
  fun getCustomers() = customers.toList()
  fun saveCustomer(id : Int, customer : Customer) {
    customers[id] = customer
  }
}
