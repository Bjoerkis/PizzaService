package com.example.pizzaservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// auto-generates constructor, getters and setters. Makes for cleaner code.
import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    private String ingredients;
    private String name;
    private int price;


    @Id
    @GeneratedValue
    private int menuNumber;


}

