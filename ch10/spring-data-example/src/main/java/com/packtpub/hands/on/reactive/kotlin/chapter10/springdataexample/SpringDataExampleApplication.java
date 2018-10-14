package com.packtpub.hands.on.reactive.kotlin.chapter10.springdataexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringDataExampleApplication {

  @Autowired
  CustomersRepository customersRepository;

  @PostConstruct
  void init() {
    customersRepository.save(new Customer("Peter", "Parker"));
    customersRepository.save(new Customer("Steve", "Rogers"));
    customersRepository.save(new Customer("Red", "Richards"));
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringDataExampleApplication.class, args);
  }
}
