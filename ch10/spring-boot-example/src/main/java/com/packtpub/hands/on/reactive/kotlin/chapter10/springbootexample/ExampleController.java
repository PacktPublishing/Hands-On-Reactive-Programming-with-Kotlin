package com.packtpub.hands.on.reactive.kotlin.chapter10.springbootexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
  private final CustomerInterface customerInterface;

  public ExampleController(CustomerInterface customerInterface) {
    this.customerInterface = customerInterface;
  }

  @GetMapping("/customer/{number}")
  Customer hello(@PathVariable int number) {
    return customerInterface.getCustomer(number);
  }
}
