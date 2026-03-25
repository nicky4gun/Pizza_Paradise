package org.example.pizza_paradise.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private LocalTime orderTime;

    public Order() {

    }
    public Order(LocalTime orderTime) {
        this.orderTime = orderTime;
    }


    public LocalTime getOrderTime() {
        return orderTime;
    }
    public void setOrderDate(LocalTime orderTime) {
        this.orderTime = orderTime;
    }
}
