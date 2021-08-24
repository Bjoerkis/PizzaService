package com.example.pizzaservice.controllers;

import com.example.pizzaservice.entities.OrderPizza;
import com.example.pizzaservice.repositories.OrderRepository;
import com.example.pizzaservice.repositories.PizzasRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

   private final OrderRepository orderRepository;


    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @PostMapping("/pizza")
    OrderPizza orderAPizza(@RequestBody OrderPizza order) {

        return orderRepository.save(order);
    }
}
