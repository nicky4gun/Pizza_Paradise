package org.example.pizza_paradise.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTests {

    @Test
    public void testTime() {
        Order order = new Order(LocalDate.of(2026, 3, 25), 0.0);
        assertEquals(LocalDate.of(2026,3,25) , order.getOrderDate());
    }

    @Test
    public void testTheNumberOfOrderLines() {
        Pizza pizza = new Pizza("hawaii", "Pizza with pineapple and ham", 70,"Hawaii.png");
        Topping pineapple = new Topping(1, "Pineapple", 10.0);
        Topping ham = new Topping(2, "Ham", 15.0);
        OrderLine orderLine = new OrderLine(1, pizza.getId(), 1);
        orderLine.setToppings(List.of(pineapple, ham));

        Order order = new Order(LocalDate.of(2026, 3, 25), 0.0);
        order.setOrderLines(List.of(orderLine));

        assertEquals(1, order.getOrderLines().size());
    }

    // Fejler
    @Test
    public void TestTheTotalPrice() {
        Pizza pizza1 = new Pizza(1, "Hawaii", "Pizza with pineapple", 70.0,"Hawaii.png");
        Pizza pizza2 = new Pizza(2, "Pepperoni", "Pizza with pepperoni", 80.0,"Pepperoni.png" );

        OrderLine line1 = new OrderLine(1, pizza1.getId(), 1);
        OrderLine line2 = new OrderLine(2, pizza2.getId(), 1);

        Order order = new Order(LocalDate.now(), 0.0);
        order.setOrderLines(List.of(line1, line2));

        assertEquals(150.0, order.getTotalPrice());
    }
}
