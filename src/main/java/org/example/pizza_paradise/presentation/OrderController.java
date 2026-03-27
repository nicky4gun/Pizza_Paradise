package org.example.pizza_paradise.presentation;

import org.example.pizza_paradise.services.OrderService;
import org.example.pizza_paradise.services.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/pizzaparadise")
public class OrderController {
    private final OrderService orderService;
    private final PizzaService pizzaService;

    public OrderController(OrderService orderService, PizzaService pizzaService) {
        this.orderService = orderService;
        this.pizzaService = pizzaService;
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.findAllOrders());
        return "pizzaMenu";
    }

    @GetMapping("/orderSummary")
    public String getOrder(@RequestParam int id, Model model) {
        model.addAttribute("order", orderService.findOrderById(id));
        model.addAttribute("orders", orderService.findAllOrders());
        model.addAttribute("pizzas", pizzaService.findPizzaById(id));
        return "orderSummary";
    }

    @PostMapping("/order")
    public String orderPizza(@RequestParam(required = false) List<Integer> pizzaIds, @RequestParam(required = false) List<Integer> toppingIds) {
        int newOrderId = orderService.saveOrder(pizzaIds, toppingIds);
        return "redirect:/pizzaparadise/orderSummary?id=" + newOrderId;
    }
}
