package com.example.Bookstore.controller;

import com.example.Bookstore.model.Order;
import com.example.Bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/id")
    public Optional<Order> getOrder(@PathVariable Integer id) {
        return orderService.getOrder(id);
    }

    @PostMapping("")
    public Order postOrder(@RequestBody Order order) {
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
