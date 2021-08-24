package com.example.pizzaservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "No pizza found corresponding to that number")
public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String s) {
        throw new RuntimeException(s);
    }
}
