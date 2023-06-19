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

    public Book updateBook(Integer id, Book newBook) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            Book toBeUpdatedBook = book.get();
            toBeUpdatedBook.setCategory(newBook.getCategory());
            toBeUpdatedBook.setPrice(newBook.getPrice());
            toBeUpdatedBook.setPublishedYear(newBook.getPublishedYear());

            return bookRepository.save(toBeUpdatedBook);
        }
        return null;
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
