package org.example.pizza_paradise.models;

import java.util.ArrayList;
import java.util.List;

public class OrderLine {
    private int id;
    private int orderId;
    private int pizzaId;
    private int quantity;
    private List<Topping> toppings = new ArrayList<>();

    public OrderLine(int id, int orderId, int pizzaId, int quantity) {
        this.id = id;
        this.orderId = orderId;
        this.pizzaId = pizzaId;
        this.quantity = quantity;
    }

    public OrderLine(int orderId, int pizzaId, int quantity) {
        this.orderId = orderId;
        this.pizzaId = pizzaId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
}
