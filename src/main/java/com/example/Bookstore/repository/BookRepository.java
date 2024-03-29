package com.example.Bookstore.repository;

import com.example.Bookstore.model.Author;
import com.example.Bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBooksByAuthors(Author author);
    List<Book> findBookByTitle(String title);
    List<Book> findBooksByCategory(String category);
    List<Book> findBooksByPrice(double price);
    List<Book> findBooksByPublishedYear(int year);

}
