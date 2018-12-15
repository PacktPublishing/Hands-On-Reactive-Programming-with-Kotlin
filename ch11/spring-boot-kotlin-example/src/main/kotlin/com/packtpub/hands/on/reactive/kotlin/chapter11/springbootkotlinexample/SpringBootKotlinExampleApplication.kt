package com.packtpub.hands.on.reactive.kotlin.chapter11.springbootkotlinexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringBootKotlinExampleApplication{
  @Bean
  fun customerInterface()  : CustomerInterface = CustomerService()
}

fun main(args: Array<String>) {
  runApplication<SpringBootKotlinExampleApplication>(*args)
}
