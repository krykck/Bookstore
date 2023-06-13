package com.example.Bookstore.controller;

import com.example.Bookstore.model.Customer;
import com.example.Bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("{/id}")
    public Optional<Customer> getCustomer(@PathVariable Integer id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("{/id}")
    public Optional<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        return customerService.updateCustomer(customer, id);
    }

    @DeleteMapping("{/id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }
}
