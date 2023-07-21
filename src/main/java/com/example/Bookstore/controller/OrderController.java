package com.example.Bookstore.controller;

import com.example.Bookstore.dto.BookDto;
import com.example.Bookstore.dto.BookOrderQuantity;
import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.Order;
import com.example.Bookstore.model.OrderBook;
import com.example.Bookstore.model.OrderBookId;
import com.example.Bookstore.service.BookService;
import com.example.Bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    @Transactional
    public Order postOrder(@RequestBody BookDto bookDto) {
        Order order = new Order();
        order.setOrderDate(new Date());
        order = orderService.createOrder(order);

        for (BookOrderQuantity boq: bookDto.getBooks()) {
            OrderBook orderBook = new OrderBook();
            orderBook.setId(new OrderBookId(boq.getId(), order.getId()));
            orderBook.setBook(bookService.getBook(boq.getId()).orElseThrow());
            orderBook.setQuantity(boq.getQuantity());
            orderBook.setOrder(order);
            order.getBooks().add(orderBook);
        }
        return orderService.createOrder(order);
        /*Double totalPrice = order.calculateTotalAmount(order);
        HashSet<OrderBook> books = (HashSet<OrderBook>) order.getBooks();
        HashSet<Book> temp = new HashSet<Book>();
        for (OrderBook b: books) {
            Optional<Book> toAdd = bookService.getBook(b.getBook().getId());
            toAdd.ifPresent(temp::add);
        }
        order.setBooks(temp);
        order.setTotalPrice(totalPrice);
        return orderService.createOrder(order);*/
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
