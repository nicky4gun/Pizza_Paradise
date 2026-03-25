package org.example.pizza_paradise.models;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private int id;
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

    public Pizza(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public int getId() {
        return id;
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
    public boolean hasToppings(String topping) {
        return toppings.contains(topping);
    }
    public void removeToppings(String topping) {
        toppings.remove(topping);
    }
    public void ClearToppings() {
        toppings.clear();
    }

}

