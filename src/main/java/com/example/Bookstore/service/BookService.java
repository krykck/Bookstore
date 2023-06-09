package com.example.Bookstore.service;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBook(Integer id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> updateBook(Integer id, Book newBook) {
        Optional<Book> toBeUpdatedBook = bookRepository.findById(id);
        if (toBeUpdatedBook.isPresent()) {
            toBeUpdatedBook.get().setAuthor(newBook.getAuthor());
            toBeUpdatedBook.get().setCategory(newBook.getCategory());
            toBeUpdatedBook.get().setPrice(newBook.getPrice());
            toBeUpdatedBook.get().setPublishedYear(newBook.getPublishedYear());
        }
        return toBeUpdatedBook;
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
