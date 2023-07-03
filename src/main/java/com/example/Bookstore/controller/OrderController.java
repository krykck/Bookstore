package com.example.Bookstore.controller;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.Order;
import com.example.Bookstore.service.BookService;
import com.example.Bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    BookService bookService;

    @GetMapping("/id")
    public Optional<Order> getOrder(@PathVariable Integer id) {
        return orderService.getOrder(id);
    }

    @PostMapping("")
    public Order postOrder(@RequestBody Order order) {
        Double totalPrice = order.calculateTotalAmount(order);
        HashSet<Book> books = (HashSet<Book>) order.getBooks();
        HashSet<Book> temp = new HashSet<Book>();
        for (Book b: books) {
            Optional<Book> toAdd = bookService.getBook(b.getId());
            toAdd.ifPresent(temp::add);
        }
        order.setBooks(temp);
        order.setTotalPrice(totalPrice);
        return orderService.createOrder(order);
    }

    @PutMapping("/id")
    public Order putOrder(@PathVariable Integer id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/id")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }
}
