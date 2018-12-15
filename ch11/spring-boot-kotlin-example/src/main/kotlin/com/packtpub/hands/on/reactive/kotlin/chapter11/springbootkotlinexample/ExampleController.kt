package com.packtpub.hands.on.reactive.kotlin.chapter11.springbootkotlinexample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController(val customerInterface: CustomerInterface) {
  @GetMapping("/customer/{id}")
  fun getCustomer(@PathVariable id: Int) = customerInterface.getCustomer(id)
}
