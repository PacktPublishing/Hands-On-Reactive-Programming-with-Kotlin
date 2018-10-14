package com.packtpub.hands.on.reactive.kotlin.chapter10.springbootexample;

import java.util.Arrays;
import java.util.List;

public class CustomerService implements CustomerInterface {
  private final static List<Customer> customers = Arrays.asList(
      new Customer("Peter", "Parker"),
      new Customer("Steve", "Rogers"),
      new Customer("Red", "Richards"));

  @Override
  public Customer getCustomer(int number) {
    return customers.get(number);
  }
}
