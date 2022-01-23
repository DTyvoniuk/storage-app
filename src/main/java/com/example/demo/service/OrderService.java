package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderService {
    List<Order> getAll();

    Order save(Order order);

    Order getById(Long id);
}
