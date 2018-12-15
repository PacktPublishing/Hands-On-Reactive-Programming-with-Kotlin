package com.packtpub.hands.on.reactive.kotlin.chapter11.springbootkotlinrestapi

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
class CustomerController(val customerRepository: CustomerRepository) {
  @GetMapping("/customers")
  fun getAllCustomers() = customerRepository.findAll().let {
    if (it.count() > 0) {
      ResponseEntity.ok(it)
    } else {
      ResponseEntity.notFound().build()
    }
  }

  @GetMapping("/customer/{id}")
  fun getCustomer(@PathVariable id: Int) = customerRepository.findById(id).let {
    if (it.isPresent) {
      ResponseEntity.ok(it.get())
    } else {
      ResponseEntity.notFound().build()
    }
  }

  @PostMapping("/customer")
  fun postCustomer(@RequestBody customer: Customer, builder: UriComponentsBuilder) =
      customerRepository.save(customer).let {
        ResponseEntity.created(builder.path("/customer/{id}").buildAndExpand(it._id).toUri()).build<Any>()
      }

  @DeleteMapping("/customer/{id}")
  fun deleteCustomer(@PathVariable id: Int) =
      if (customerRepository.findById(id).isPresent) {
        customerRepository.deleteById(id)
        ResponseEntity.noContent().build<Any>()
      } else {
        ResponseEntity.notFound().build<Any>()
      }
}

