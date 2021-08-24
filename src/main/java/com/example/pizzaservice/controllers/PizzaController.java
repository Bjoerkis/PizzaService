package com.example.pizzaservice.controllers;

import com.example.pizzaservice.repositories.PizzasRepository;
import com.example.pizzaservice.ResourceNotFound;
import com.example.pizzaservice.entities.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {


    private final PizzasRepository pizzasRepository;

    public PizzaController(PizzasRepository pizzasRepository) {
        this.pizzasRepository = pizzasRepository;
    }

    @GetMapping
    List<Pizza> getPizzaMenu(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "ingredients", required = false) String ingredients) {

        if (name != null) {

            return pizzasRepository.findByName(name);

        } else if (ingredients != null) {
            //Right now you have to enter the entire ingredients list.
            return pizzasRepository.findByIngredients(ingredients);

        } else

            return pizzasRepository.findAll();

    }

    @PostMapping
    Pizza saveAPizza(@RequestBody Pizza pizza) {

        return pizzasRepository.save(pizza);

    }

    @PutMapping("/{menuNumber}")
    Pizza updateAPizza(@RequestBody Pizza pizza, @PathVariable(value = "menuNumber") int menuNumber) {
        Pizza newPizza = pizzasRepository.findByMenuNumber(menuNumber).orElseThrow(() -> new ResourceNotFound
                ("No pizza currently corresponds to this menu number" + menuNumber));
        newPizza.setMenuNumber(menuNumber);

        newPizza.setIngredients(pizza.getIngredients());
        newPizza.setPrice(pizza.getPrice());
        newPizza.setName(pizza.getName());

        return pizzasRepository.save(newPizza);

    }

    @DeleteMapping("/{menuNumber}")
    Map<String, Boolean> deleteAPizza(@PathVariable(value = "menuNumber") int menuNumber) {
        Pizza deletedPizza = pizzasRepository.findById(menuNumber).orElseThrow(() -> new ResourceNotFound("No pizza currently corresponds to menu number" + menuNumber));

        pizzasRepository.delete(deletedPizza);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PatchMapping(value = "/{menuNumber}/{name}/{price}/{ingredients}")
    public ResponseEntity<Pizza> partialPizzaUpdateName(@PathVariable int menuNumber,
                                                        @PathVariable String name,
                                                        @PathVariable int price,@PathVariable String ingredients) {
        try {
            Pizza pizza = pizzasRepository.findById(menuNumber).get();
            pizza.setName(name);
            pizza.setPrice(price);
            pizza.setIngredients(ingredients);
            return new ResponseEntity<>(pizzasRepository.save(pizza), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}



