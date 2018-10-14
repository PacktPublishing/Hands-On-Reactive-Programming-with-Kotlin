package com.packtpub.hands.on.reactive.kotlin.chapter10.springbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootExampleApplication {
  @Bean
  CustomerInterface customerInterface() {
    return new CustomerService();
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringBootExampleApplication.class, args);
  }
}
