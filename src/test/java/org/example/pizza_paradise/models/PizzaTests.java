package org.example.pizza_paradise.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaTests {

    @Test
    void pizzaNameIsHawaii() {
        Pizza pizza = new Pizza("Hawaii", "",0.0);
        assertEquals("Hawaii", pizza.getName());
    }

    @Test
    void pizzaDescriptionIsPineappleAndHam() {
        Pizza pizza = new Pizza("", "Pizza has pineapple and ham",0.0);
        assertEquals("Pizza has pineapple and ham",pizza.getDescription());
    }

    @Test
    void pizzaHasAPrice(){
        Pizza pizza = new Pizza("", "", 70);
        assertEquals(70, pizza.getPrice());
    }

    @Test
    void pizzaHasToppings(){
        Pizza pizza = new Pizza("", "", 0.0);

        pizza.addToppings("Pineapple");
        pizza.addToppings("Ham");

        List<String> expected = List.of("Pineapple", "Ham");
        assertEquals(expected, pizza.getToppings());
    }
}
