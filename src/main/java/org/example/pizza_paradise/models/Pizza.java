package org.example.pizza_paradise.models;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private String description;
    private double price;
    private List<String> toppings = new ArrayList<>();

    public Pizza() {}

    public Pizza(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addToppings(String topping) {
        toppings.add(topping); // Needs a throw
    }

    public List<String> getToppings() {
        return toppings;
    }
}
