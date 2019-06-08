package com.packtpub.hands.on.reactive.kotlin.chapter12.webfluxexample

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CustomerService {
  fun getCustomer(id: Int): Mono<Customer>
  fun searchCustomers(filter: String): Flux<Customer>
  fun createCustomer(customerMono: Mono<Customer>) : Mono<Customer>
}
