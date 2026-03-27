package org.example.pizza_paradise.infrastructure;

import org.example.pizza_paradise.models.Order;
import org.example.pizza_paradise.models.OrderLine;
import org.example.pizza_paradise.models.Topping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveOrder(Order order) {
        String sql = "INSERT INTO orders (order_date, total_price) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, order.getOrderDate());
            ps.setDouble(2, order.getTotalPrice());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    public int saveOrderLine(int orderId, int pizzaId, int quantity) {
        String sql = "INSERT INTO order_lines (order_id, pizza_id, quantity) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, orderId);
            ps.setInt(2, pizzaId);
            ps.setInt(3, quantity);
            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    public void saveToppingForOrderLine(int orderLineId, int toppingId) {
        String sql = "INSERT INTO order_lines_toppings (order_line_id, topping_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, orderLineId, toppingId);
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

        return Optional.of(orders.getFirst());
    }

    public List<OrderLine> findOrderLinesByOrderId(int orderId) {
        String sql = "SELECT * FROM order_lines WHERE order_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new OrderLine(
                rs.getInt("id"),
                rs.getInt("order_id"),
                rs.getInt("pizza_id"),
                rs.getInt("quantity")
        ), orderId);
    }

    public List<Topping> findToppingsByOrderLineId(int orderLineId) {
        String sql = """
                    SELECT t.* FROM toppings t
                    JOIN order_lines_toppings olt ON t.id = olt.topping_id
                    WHERE olt.order_line_id = ?""";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new Topping(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("price")
        ), orderLineId);
    }
}
