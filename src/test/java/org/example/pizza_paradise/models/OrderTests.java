package org.example.pizza_paradise.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTests {

    @Test
    public void testTime() {
        Order order = new Order(14:10);
        assertEquals(14:10, order.getOrderTime());


    }




}
