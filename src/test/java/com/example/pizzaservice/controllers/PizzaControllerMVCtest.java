package com.example.pizzaservice.controllers;


import com.example.pizzaservice.repositories.PizzasRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//testing method
@WebMvcTest(controllers = {PizzaController.class})
public class PizzaControllerMVCtest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PizzasRepository pizzasRepository;

    @Test
    void getEmPizzas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pizzas"))
                .andExpect(status().is(200));
    }
}

