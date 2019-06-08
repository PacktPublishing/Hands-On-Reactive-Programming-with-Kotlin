package com.packtpub.hands.on.reactive.kotlin.chapter12.webfluxexample

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.toMono

@Component
class CustomerHandler(val customerService: CustomerService) {
  fun get(serverRequest: ServerRequest) =
    customerService.getCustomer(serverRequest.pathVariable("id").toInt())
      .flatMap { ok().body(it.toMono()) }
      .switchIfEmpty(notFound().build())

  fun search(serverRequest: ServerRequest) =
    ok().body(customerService.searchCustomers(serverRequest.queryParam("filter").orElse("")))

  fun post(serverRequest: ServerRequest) =
    customerService.createCustomer(serverRequest.bodyToMono()).flatMap {
      created(serverRequest.uriBuilder().path("/{id}").build(it.id)).build()
    }
}
