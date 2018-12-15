package com.packtpub.hands.on.reactive.kotlin.chapter11.springbootkotlinexample

class CustomerService : CustomerInterface {
  companion object {
    val customers = hashMapOf(
        1 to Customer("Peter", "Parker"),
        2 to Customer("Steve", "Rogers"),
        3 to Customer("Red", "Richards")
    )
  }
  override fun getCustomer(id: Int) = customers[id]
}
