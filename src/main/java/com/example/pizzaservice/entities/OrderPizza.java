package com.example.pizzaservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderPizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderNr;
    private int price;
    private String pizzaOrder;
    private String phoneNr;


}
