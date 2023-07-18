package com.example.Bookstore.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookDto {
    private List<BookOrderQuantity> books;
}
