package com.example.Bookstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Book")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="publishedYear")
    private int publishedYear;
    @Column(name="category")
    private String category;
    @Column(name="price")
    private double price;
}
