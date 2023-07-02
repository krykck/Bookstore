package com.example.Bookstore.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Table(name="orders")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date orderDate;

    private Double totalPrice;

    public Double calculateTotalAmount(Order order) {
        double totalAmount = 0;
        for(Book book : books) {
            totalAmount += book.getPrice() * book.getQuantity();
        }
        return totalAmount;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "order_book",
        joinColumns = {
            @JoinColumn(name = "order_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "book_id")
        }
    )
    private Set<Book> books = new HashSet<>();

}
