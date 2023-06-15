package com.example.Bookstore.repository;

import com.example.Bookstore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findCustomerByFirstName(String firstName);
    List<Customer> findCustomerByLastName(String lastName);
}
