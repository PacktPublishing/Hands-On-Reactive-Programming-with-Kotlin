package com.packtpub.hands.on.reactive.kotlin.chapter12.webfluxexample

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono
import java.util.concurrent.ConcurrentHashMap

@Service
class CustomerServiceImpl : CustomerService {
  companion object {
    private val initialCustomers = hashMapOf(
      1 to Customer(1, "Peter", "Parker"),
      2 to Customer(2, "Steve", "Rogers"),
      3 to Customer(3, "Red", "Richards")
    )
  }

  private val customers = ConcurrentHashMap(initialCustomers)

  override fun getCustomer(id: Int): Mono<Customer> {
    return customers[id]?.toMono() ?: Mono.empty()
  }

  override fun searchCustomers(filter: String) =
    customers.filter {
      it.value.let {
        it.name.contains(filter, true) or it.surname.contains(filter, true)
      }
    }.map(Map.Entry<Int, Customer>::value).toFlux()

  override fun createCustomer(customerMono: Mono<Customer>) = customerMono.map {
    customers[it.id] = it
    it
  }
}
