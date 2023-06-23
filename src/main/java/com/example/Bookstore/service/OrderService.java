package com.example.Bookstore.service;

import com.example.Bookstore.model.Order;
import com.example.Bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> getOrder(Integer id) {
        return orderRepository.findById(id);
    }

    public Order updateOrder(Integer id, Order newOrder) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()) {
            Order orderToBeUpdated = order.get();
            orderToBeUpdated.setOrderDate(newOrder.getOrderDate());
            orderToBeUpdated.setPrice(newOrder.getPrice());
            return orderToBeUpdated;
        }
        return null;
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
