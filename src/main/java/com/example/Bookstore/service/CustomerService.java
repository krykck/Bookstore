package com.example.Bookstore.service;

import com.example.Bookstore.model.Customer;
import com.example.Bookstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Optional<Customer> getCustomer(Integer id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> updateCustomer(Customer customer, Integer id) {
        Optional<Customer> customerToBeUpdated = customerRepository.findById(id);
        if(customerToBeUpdated.isPresent()) {
            customerToBeUpdated.get().setFirstName(customer.getFirstName());
            customerToBeUpdated.get().setLastName(customer.getLastName());
            customerToBeUpdated.get().setAddress(customer.getAddress());
            customerToBeUpdated.get().setEmail(customer.getEmail());
        }

        return customerToBeUpdated;
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
