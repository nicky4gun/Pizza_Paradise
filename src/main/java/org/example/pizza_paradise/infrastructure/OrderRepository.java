package org.example.pizza_paradise.infrastructure;

import org.example.pizza_paradise.models.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveOrder(Order order) {
        String sql = "INSERT INTO orders (order_date, total_price) VALUES (?, ?)";
        jdbcTemplate.update(sql, order.getOrderDate(), order.getTotalPrice());
    }

    public void addPizzaToOrder(int orderId, int pizzaId) {
        String sql  = "INSERT INTO order_pizzas (order_id, pizza_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, orderId, pizzaId);
    }

    public List<Order> findAllOrders() {
        String sql = "SELECT id, order_date, total_price FROM orders";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Order(
                        rs.getInt("id"),
                        rs.getDate("order_date").toLocalDate(),
                        rs.getDouble("total_price")
                )
        );
    }

    public Optional<Order> findOrderById(int orderId) {
        String sql = "SELECT id, order_date, total_price FROM orders WHERE id = ?";

        List<Order> orders = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Order(
                        rs.getInt("id"),
                        rs.getDate("order_date").toLocalDate(),
                        rs.getDouble("total_price")
                ), orderId
        );

        if (orders.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(orders.get(0));
    }
}
