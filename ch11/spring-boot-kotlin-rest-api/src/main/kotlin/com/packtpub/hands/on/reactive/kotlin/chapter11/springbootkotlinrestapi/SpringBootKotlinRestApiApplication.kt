package com.packtpub.hands.on.reactive.kotlin.chapter11.springbootkotlinrestapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class SpringBootKotlinRestApiApplication(val customerRepository: CustomerRepository) {
  @PostConstruct
  fun postConstruct() {
    customerRepository.deleteAll();
    customerRepository.saveAll(listOf(
        Customer(1, "Peter", "Parker",
            ContactDetails("1-123-456-7890", "peter.parker@dailybugle.com")),
        Customer(2, "Steve", "Rogers",
            ContactDetails("1-123-456-7891", "captain.america@avengers.com")),
        Customer(3, "Red", "Richards",
            ContactDetails("1-123-456-7892", "red.richards@baxter.com"))
    ))
  }
}

fun main(args: Array<String>) {
  runApplication<SpringBootKotlinRestApiApplication>(*args)
}
