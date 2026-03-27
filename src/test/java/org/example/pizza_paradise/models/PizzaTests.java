package org.example.pizza_paradise.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaTests {

    @Test
    void pizzaNameIsHawaii() {
        Pizza pizza = new Pizza("Hawaii", "",0.0,"Hawaii.png");
        assertEquals("Hawaii", pizza.getName());
    }

    @Test
    void pizzaDescriptionIsPineappleAndHam() {
        Pizza pizza = new Pizza("", "Pizza has pineapple and ham",0.0,"Hawaii.png");
        assertEquals("Pizza has pineapple and ham",pizza.getDescription());
    }

    @Test
    void pizzaHasAPrice(){
        Pizza pizza = new Pizza("", "", 70,"Pizza.png");
        assertEquals(70, pizza.getPrice());
    }
}
