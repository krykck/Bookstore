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

    public Customer updateCustomer(Customer newCustomer, Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            Customer customerToBeUpdated = customer.get();
            customerToBeUpdated.setFirstName(newCustomer.getFirstName());
            customerToBeUpdated.setLastName(newCustomer.getLastName());
            customerToBeUpdated.setAddress(newCustomer.getAddress());
            customerToBeUpdated.setEmail(newCustomer.getEmail());

            return customerRepository.save(customerToBeUpdated);
        }

        return null;
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
