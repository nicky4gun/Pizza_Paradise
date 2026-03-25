DROP TABLE IF EXISTS toppings;
DROP TABLE IF EXISTS order_pizzas;
DROP TABLE IF EXISTS pizzas;
DROP TABLE IF EXISTS orders;

CREATE TABLE IF NOT EXISTS pizzas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price DOUBLE
);

CREATE TABLE IF NOT EXISTS toppings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    price DOUBLE
);

CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_date DATE,
    total_price DOUBLE
);

CREATE TABLE IF NOT EXISTS order_pizzas (
    order_id INT,
    pizza_id INT,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (pizza_id) REFERENCES pizzas(id)
);