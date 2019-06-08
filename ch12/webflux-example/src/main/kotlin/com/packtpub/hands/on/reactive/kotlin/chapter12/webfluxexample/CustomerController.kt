package com.packtpub.hands.on.reactive.kotlin.chapter12.webfluxexample

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import reactor.core.publisher.switchIfEmpty
import reactor.core.publisher.toMono

@RestController
class CustomerController(val customerService: CustomerService) {
  @GetMapping(value = ["/customer/{id}"])
  fun getCustomer(@PathVariable id: Int) =
    customerService.getCustomer(id).map {
      ResponseEntity(it, HttpStatus.OK)
    }.switchIfEmpty {
      ResponseEntity.notFound().build<Customer>().toMono()
    }

  @GetMapping(value = ["/customers"])
  fun getCustomers(@RequestParam(required = false, defaultValue = "")
                   nameFilter: String) =
    ResponseEntity(customerService.searchCustomers(nameFilter), HttpStatus.OK)

  @PostMapping("/customer")
  fun postCustomer(@RequestBody customer: Mono<Customer>, builder: UriComponentsBuilder) =
    customerService.createCustomer(customer).map {
      ResponseEntity.created(builder.path("/customer/{id}").buildAndExpand(it.id)
        .toUri()).build<Any>()
    }
}