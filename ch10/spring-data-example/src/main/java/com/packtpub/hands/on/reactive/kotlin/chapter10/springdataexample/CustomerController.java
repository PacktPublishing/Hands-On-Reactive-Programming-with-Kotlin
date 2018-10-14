package com.packtpub.hands.on.reactive.kotlin.chapter10.springdataexample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
public class CustomerController {
  private final CustomersRepository customersRepository;

  public CustomerController(CustomersRepository customersRepository) {
    this.customersRepository = customersRepository;
  }

  @GetMapping("/customer/{id}")
  ResponseEntity<?> getCustomer(@PathVariable Integer id) {
    final Optional<Customer> optionalCustomer = customersRepository.findById(id);
    if (optionalCustomer.isPresent()) {
      return ResponseEntity.ok(optionalCustomer.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/customer")
  ResponseEntity<?> postCustomer(@RequestBody Customer customer,
                                 UriComponentsBuilder builder) {
    final Customer savedCustomer = customersRepository.save(customer);
    final UriComponents uriComponents = builder.
        path("/customers/{id}").
        buildAndExpand(savedCustomer.getId());
    return ResponseEntity.created(uriComponents.toUri()).build();
  }

  @PatchMapping("/customer/{id}")
  ResponseEntity<?> patchCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
    final Optional<Customer> possibleCustomer = customersRepository.findById(id);
    if (possibleCustomer.isPresent()) {
      final Customer foundCustomer = possibleCustomer.get();
      foundCustomer.setName(customer.getName());
      foundCustomer.setSurname(customer.getSurname());
      customersRepository.save(foundCustomer);
      return ResponseEntity.accepted().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/customer/{id}")
  ResponseEntity<?> deleteCustomer(@PathVariable Integer id) {
    final Optional<Customer> possibleCustomer = customersRepository.findById(id);
    if (possibleCustomer.isPresent()) {
      customersRepository.delete(possibleCustomer.get());
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/customers")
  ResponseEntity<?> getAllCustomers(){
    final Iterable<Customer> all = customersRepository.findAll();
    final long count = StreamSupport.stream(all.spliterator(), false).count();
    if(count>0){
      return ResponseEntity.ok(all);
    }else {
      return ResponseEntity.notFound().build();
    }
  }
}
