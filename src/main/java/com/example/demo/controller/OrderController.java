package com.example.demo.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.dto.request.FruitRequestDto;
import com.example.demo.model.Fruit;
import com.example.demo.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.FruitService;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final FruitService fruitService;
    private final OrderService orderService;

    public OrderController(FruitService fruitService, OrderService orderService) {
        this.fruitService = fruitService;
        this.orderService = orderService;
    }

    @PostMapping
    public Order completeOrder(@RequestBody List<FruitRequestDto> fruits) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setPrice(BigDecimal.ZERO);
        StringBuilder report = new StringBuilder();
        for (FruitRequestDto fruit : fruits) {
            Fruit fruitFromDb = fruitService.getByName(fruit.getName());
            if (fruitFromDb.getQuantity() < fruit.getQuantity()) {
                throw new RuntimeException("Can't complete order, not enough " + fruit.getName());
            }
            fruitFromDb.setQuantity(fruitFromDb.getQuantity() - fruit.getQuantity());
            fruitService.save(fruitFromDb);
            report.append(fruit.getName())
                    .append(" - ")
                    .append(fruit.getQuantity())
                    .append(System.lineSeparator());
            order.setPrice(order.getPrice().add(BigDecimal
                    .valueOf(fruit.getQuantity() * fruitFromDb.getPrice().longValue())));
        }
        order.setFruits(report.toString());
        return orderService.save(order);
    }

    @GetMapping("/history")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/available")
    public List<Order> getAvailable() {
        return orderService.getAll().stream()
                .filter(o -> !o.getOrderDate().isBefore(LocalDateTime.now().minusMinutes(10)))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable(value = "id") Long id) {
        return orderService.getById(id);
    }
}
