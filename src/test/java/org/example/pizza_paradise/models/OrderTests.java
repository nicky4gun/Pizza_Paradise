package org.example.pizza_paradise.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTests {

    @Test
    public void testTime() {
        Order order = new Order(LocalDate.of(2026, 3, 25), 0.0);
        assertEquals(LocalDate.of(2026,3,25) , order.getOrderDate());
    }

    @Test
    public void testTheNumbersOfPizzas() {
        Order order = new Order(LocalDate.of(2026, 3, 25), 0.0);
        Pizza pizza = new Pizza("hawaii", "Pizza with pineapple and ham", 70);
        pizza.addToppings("Pineapple");
        pizza.addToppings("Ham");

        order.addPizza(pizza);

        List<Pizza> expected = List.of(pizza);

        assertEquals(LocalDate.of(2026, 3, 25), order.getOrderDate());
        assertEquals(expected, order.getPizza());
    }

    @Test
    public void TestTheTotalPrice() {
        Order order = new Order();
        Pizza pizza1 = new Pizza("hawaii", "Pizza with pineapple", 70);
        Pizza pizza2 = new Pizza("Pepperroni","Pizza with pepperoni",80);

        order.addPizza(pizza1);
        order.addPizza(pizza2);

        double total = order.getTotalPrice();

        assertEquals(150, total);
    }
}
