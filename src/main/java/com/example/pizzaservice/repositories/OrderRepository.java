package com.example.pizzaservice.repositories;

import com.example.pizzaservice.entities.OrderPizza;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface OrderRepository extends JpaRepository<OrderPizza,Integer> {

}
