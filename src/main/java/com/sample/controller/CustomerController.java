package com.sample.controller;

import com.sample.model.Customer;
import com.sample.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        Long status = customerService.create(customer);
        return new ResponseEntity<>(String.valueOf(status), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Long status = customerService.update(customer, id);
        return new ResponseEntity<>(String.valueOf(status), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> retrieveCustomer(@PathVariable Long id){
        Customer customer = customerService.retrieve(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(String.valueOf(id), HttpStatus.OK);
    }
}
