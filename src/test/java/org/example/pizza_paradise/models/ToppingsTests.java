package org.example.pizza_paradise.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToppingsTests {

    @Test
    void toppingHasAName(){
        Topping topping = new Topping("Pineapple",0.0);
        assertEquals("Pineapple",topping.getName());
    }

    @Test
    void toppingHasAPrice(){
        Topping topping = new Topping("",10);
        assertEquals(10,topping.getPrice());

    }
}
