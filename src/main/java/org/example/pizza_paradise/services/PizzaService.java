package org.example.pizza_paradise.services;

import org.example.pizza_paradise.infrastructure.PizzaRepository;
import org.example.pizza_paradise.models.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public void createPizza(String name, String description, double price){
        Pizza pizza = new Pizza(name,description,price);
        pizzaRepository.save(pizza);
    }

    public void addPizzaToppings(Pizza pizza,String topping){
        pizza.addToppings(topping);
    }

    public void removePizzaToppings(Pizza pizza,String topping){
        pizza.getToppings().remove(topping);
    }

    public List<Pizza> getAllPizzas(){
        return pizzaRepository.findAllPizzas();
    }



}
