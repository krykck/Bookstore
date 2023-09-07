package com.example.Bookstore.repository;

import com.example.Bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findUserByFirstName(String firstName);
    List<User> findUserByLastName(String lastName);
    Optional<User> findUserByEmail(String email);
}
