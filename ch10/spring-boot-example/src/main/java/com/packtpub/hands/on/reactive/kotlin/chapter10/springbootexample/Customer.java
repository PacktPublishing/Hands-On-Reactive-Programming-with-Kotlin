package com.packtpub.hands.on.reactive.kotlin.chapter10.springbootexample;

public class Customer {
  private String name;
  private String surname;

  public Customer(final String name, final String surname) {
    this.name = name;
    this.surname = surname;
  }

  public Customer() {
    this("", "");
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(final String surname) {
    this.surname = surname;
  }
}
