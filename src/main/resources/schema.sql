DROP TABLE IF EXISTS order_lines_toppings;
DROP TABLE IF EXISTS order_lines;
DROP TABLE IF EXISTS pizzas;
DROP TABLE IF EXISTS toppings;
DROP TABLE IF EXISTS orders;

CREATE TABLE IF NOT EXISTS pizzas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price DOUBLE,
    image_url VARCHAR(150)
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

CREATE TABLE IF NOT EXISTS order_lines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    pizza_id INT,
    quantity INT,

    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (pizza_id) REFERENCES pizzas(id)
);

CREATE TABLE IF NOT EXISTS order_lines_toppings (
    order_line_id INT,
    topping_id INT,

    PRIMARY KEY (order_line_id, topping_id),
    FOREIGN KEY (order_line_id) REFERENCES order_lines(id),
    FOREIGN KEY (topping_id) REFERENCES toppings(id)
);
