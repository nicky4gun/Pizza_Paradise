package org.example.pizza_paradise.infrastructure;

import org.example.pizza_paradise.models.Pizza;
import org.example.pizza_paradise.models.Topping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PizzaRepository {

    private final JdbcTemplate jdbcTemplate;

    public PizzaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pizza> findAllPizzas() {
        String sql = "SELECT id, name, description, price, image_url FROM pizzas ORDER BY id";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                        new Pizza(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getDouble("price"),
                                rs.getString("image_url")
                        )
        );
    }

    public Optional<Pizza> findPizzaById(int id) {
        String sql = "SELECT id, name, description, price, image_url FROM pizzas WHERE id = ?";

        List<Pizza> pizzas = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Pizza(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("image_url")
                ),
                id
        );

        if (pizzas.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(pizzas.getFirst());
    }

    public List<Topping> findAllToppings() {
        String sql = "SELECT id, name, price FROM toppings ORDER BY name";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Topping(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                )
        );
    }

    public Optional<Topping> findToppingById(int id) {
        String sql = "SELECT id, name, price FROM toppings WHERE id = ?";

        List<Topping> toppings = jdbcTemplate.query(sql, (rs, rowNum) -> new Topping(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("price")
        ), id);

        if (toppings.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(toppings.getFirst());
    }
}
