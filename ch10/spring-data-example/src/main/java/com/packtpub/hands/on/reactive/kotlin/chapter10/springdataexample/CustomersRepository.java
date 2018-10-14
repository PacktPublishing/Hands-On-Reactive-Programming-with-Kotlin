package com.packtpub.hands.on.reactive.kotlin.chapter10.springdataexample;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends CrudRepository<Customer, Integer> {
}
