package org.example.pizza_paradise.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private LocalDate orderDate;
    private double totalPrice;
    private List<Pizza> pizzas = new ArrayList<>();

    public Order() {}

    public Order(LocalDate orderDate, double totalPrice) {
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    public Order(int id, LocalDate orderDate, double totalPrice) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<Pizza> getPizza() {
        return pizzas;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }
    public double getTotalPrice() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.getPrice();
        }
        return total;
    }
}
