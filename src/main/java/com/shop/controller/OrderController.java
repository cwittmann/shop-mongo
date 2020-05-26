package com.shop.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.shop.exception.NotFoundException;
import com.shop.model.Order;
import com.shop.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order not found: " + id));
    }

    @PostMapping("/orders")
    public Order postOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @PutMapping("/orders")
    public Order putOrder(@RequestBody Order newOrder, @PathVariable String id) {
        return orderRepository.findById(id).map(order -> {
            return orderRepository.save(newOrder);
        }).orElseThrow(() -> new NotFoundException("Article not found: " + id));
    }

    @DeleteMapping("/orders")
    public void deleteOrder(@PathVariable String id) {
        orderRepository.deleteById(id);
    }
}