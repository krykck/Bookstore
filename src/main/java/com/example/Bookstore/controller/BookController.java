package com.example.Bookstore.controller;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/{id}")
    public Optional<Book> getBook(@PathVariable Integer id) {
        return bookService.getBook(id);
    }

    @PostMapping("/{book}")
    public Book saveNewBook(@PathVariable Book book) {
        return bookService.createBook(book);
    }


}