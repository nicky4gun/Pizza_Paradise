package org.example.pizza_paradise.services;

import org.example.pizza_paradise.infrastructure.PizzaRepository;
import org.example.pizza_paradise.models.Pizza;

import org.example.pizza_paradise.models.Topping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getAllPizzas(){
        return pizzaRepository.findAllPizzas();
    }

    public Optional<Pizza> findPizzaById(int id) {
        return pizzaRepository.findPizzaById(id);
    }

    public List<Topping> findAllToppings(){
        return pizzaRepository.findAllToppings();
    }

    public Topping findToppingById(int id) {
        return pizzaRepository.findToppingById(id).orElseThrow();
    }
}
