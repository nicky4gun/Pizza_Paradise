package org.example.pizza_paradise.services;

import org.example.pizza_paradise.infrastructure.OrderRepository;
import org.example.pizza_paradise.models.Order;
import org.example.pizza_paradise.models.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private void saveOrder(Order order, Pizza pizza) {
        orderRepository.saveOrder(order);
        orderRepository.addPizzaToOrder(order.getId(), pizza.getId());
    }

    public double calculatePrice(Order order){
        return order.getTotalPrice();
    }

    public List<Order> getOrderHistory(){
        return orderRepository.findAllOrders();
    }
}
