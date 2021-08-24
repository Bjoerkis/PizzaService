package com.example.pizzaservice.repositories;

import com.example.pizzaservice.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PizzasRepository extends JpaRepository<Pizza, Integer> {

    List<Pizza> findByName(String name);

    List<Pizza> findByIngredients(String ingredients);

    Optional<Pizza> findByMenuNumber(int menuNumber);


}
