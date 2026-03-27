package org.example.pizza_paradise.services;

import org.example.pizza_paradise.infrastructure.OrderRepository;
import org.example.pizza_paradise.infrastructure.PizzaRepository;
import org.example.pizza_paradise.models.Order;
import org.example.pizza_paradise.models.OrderLine;
import org.example.pizza_paradise.models.Topping;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;

    public OrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository) {
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
    }

    public int saveOrder(List<Integer> pizzaIds, List<Integer> toppingIds) {
        double total = calculatePrice(pizzaIds, toppingIds);

        if (pizzaIds == null || pizzaIds.isEmpty()) {
            throw new IllegalArgumentException("Pizza Ids cannot be null or empty");
        }

        Order orderToSave = new Order(LocalDate.now(), total);
        int orderId = orderRepository.saveOrder(orderToSave);

        for (int pizzaId : pizzaIds) {
            if (pizzaRepository.findPizzaById(pizzaId).isEmpty()) {
                throw new IllegalArgumentException("Pizza with id " + pizzaId + " not found");
            }
            int orderLineId = orderRepository.saveOrderLine(orderId, pizzaId, 1);

            for (int toppingId : toppingIds) {
                if (pizzaRepository.findPizzaById(toppingId).isEmpty()) {
                    throw new IllegalArgumentException("Topping with id " + toppingId + " not found");
                }
                orderRepository.saveToppingForOrderLine(orderLineId, toppingId);
            }
        }

        return orderId;
    }

    public double calculatePrice(List<Integer> pizzaIds, List<Integer> toppingIds) {
        double totalPrice = 0.0;
        if (pizzaIds == null || pizzaIds.isEmpty()) {
            return 0;
        }

        for (int pizzaId : pizzaIds) {
            totalPrice += pizzaRepository.findPizzaById(pizzaId).orElseThrow().getPrice();
        }

        for (int toppingId : toppingIds) {
            totalPrice += pizzaRepository.findToppingById(toppingId).orElseThrow().getPrice();

        }

        return totalPrice;
    }

    public List<Order> findAllOrders() {
        List<Order> orders = orderRepository.findAllOrders();

        for (Order order : orders) {
            List<OrderLine> orderLines = orderRepository.findOrderLinesByOrderId(order.getId());

            for (OrderLine orderLine : orderLines) {
                List<Topping> toppings = orderRepository.findToppingsByOrderLineId(orderLine.getId());
                orderLine.setToppings(toppings);
            }

            order.setOrderLines(orderLines);
        }

        return orders;
    }

    public Order findOrderById(int id) {
        if  (id<= 0){
            throw new IllegalArgumentException("Order Id must be greater than 0");
        }

        Order order = orderRepository.findOrderById(id).orElseThrow();
        List<OrderLine> orderLines = orderRepository.findOrderLinesByOrderId(id);

        for (OrderLine orderLine : orderLines) {
            List<Topping> toppings = orderRepository.findToppingsByOrderLineId(orderLine.getId());
            orderLine.setToppings(toppings);
        }

        order.setOrderLines(orderLines);
        return order;
    }
}
