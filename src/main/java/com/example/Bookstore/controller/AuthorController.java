package com.example.Bookstore.controller;

import com.example.Bookstore.model.Author;
import com.example.Bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/{id}")
    public Optional<Author> getAuthor(@PathVariable Integer id) {
        return authorService.getAuthor(id);
    }

    @PostMapping("/author")
    public Author newAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    public Author replaceAuthor(@RequestBody Author newAuthor, @PathVariable Integer id) {
        return authorService.updateAuthor(id, newAuthor);
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthor(id);
    }
}
