package com.example.Bookstore.repository;

import com.example.Bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAuthorsByLastName(String lastName);
    List<Author> findAuthorsByFirstName(String firstName);
}
