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

    @PostMapping("")
    public Author newAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PutMapping("/{id}")
    public Author replaceAuthor(@PathVariable Integer id, @RequestBody Author newAuthor) {
        return authorService.updateAuthor(id, newAuthor);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthor(id);
    }
}
