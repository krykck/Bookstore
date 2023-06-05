package com.example.Bookstore.service;

import com.example.Bookstore.model.Author;
import com.example.Bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    //create
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    //read
    public Optional<Author> getAuthor(Integer id) {
        return authorRepository.findById(id);
    }

    //delete
    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }

    //update
    public Author updateAuthor(Integer id, Author authorDetails) {
        Author author = authorRepository.findById(id).get();
        author.setFirstName(authorDetails.getFirstName());
        author.setLastName(authorDetails.getLastName());
        author.setBooks(authorDetails.getBooks());

        return author;
    }
}
