package com.packtpub.hands.on.reactive.kotlin.chapter11.springbootkotlinrestapi

import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Int>