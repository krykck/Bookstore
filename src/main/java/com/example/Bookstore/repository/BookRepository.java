package com.example.Bookstore.repository;

import com.example.Bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBookByAuthor();
    List<Book> findBookByTitle();
    List<Book> findBooksByCategory();
    List<Book> findBooksByPrice();
    List<Book> findBooksByPublishedYear();

}
