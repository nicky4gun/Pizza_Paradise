package org.example.pizza_paradise.presentation;

import org.example.pizza_paradise.models.Pizza;
import org.example.pizza_paradise.services.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/pizza")
    public String showPizzaMenu(Model model) {
        model.addAttribute("pizza", new Pizza());
        model.addAttribute("pizzas", pizzaService.getAllPizzas());
        return "pizzaView";
    }

    @PostMapping("/order")
    public String orderPizza(Pizza pizza, Model model) {}
}
