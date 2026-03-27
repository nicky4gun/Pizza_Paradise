package org.example.pizza_paradise.models;

public class Topping {
    private int id;
    private String name;
    private double price;

    public Topping() {}

    public Topping(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Topping(int id, String name, double price) {
        this.id = id;
        this.name = name;
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

    public double getPrice() {
        return price;
    }
}
