package repository;

import agregator.Order;
import agregator.OrderItem;
import agregator.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private Connection connection;

    public OrderRepositoryImpl() {
        // Инициализация соединения с базой данных
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Order order) {
        // Сохранение заказа в базу данных
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO orders (id) VALUES (?)");
            statement.setInt(1, order.getId());
            statement.executeUpdate();

            for (OrderItem item : order.getItems()) {
                statement = connection
                        .prepareStatement("INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)");
                statement.setInt(1, order.getId());
                statement.setInt(2, item.getProduct().getId());
                statement.setInt(3, item.getQuantity());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order loadById(int orderId) {
        // Загрузка заказа по ID из базы данных
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE id = ?");
            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Order order = new Order(resultSet.getInt("id"));

                PreparedStatement itemStatement = connection
                        .prepareStatement("SELECT * FROM order_items WHERE order_id = ?");
                itemStatement.setInt(1, orderId);
                ResultSet itemResultSet = itemStatement.executeQuery();

                while (itemResultSet.next()) {
                    int productId = itemResultSet.getInt("product_id");
                    int quantity = itemResultSet.getInt("quantity");

                    // Загрузка продукта из базы данных
                    PreparedStatement productStatement = connection
                            .prepareStatement("SELECT * FROM products WHERE id = ?");
                    productStatement.setInt(1, productId);
                    ResultSet productResultSet = productStatement.executeQuery();

                    if (productResultSet.next()) {
                        Product product = new Product(productResultSet.getInt("id"), productResultSet.getString("name"),
                                productResultSet.getDouble("price"));
                        OrderItem item = new OrderItem(product, quantity);
                        order.addItem(item);
                    }
                }

                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Order> loadAll() {
        // Загрузка всех заказов из базы данных
        List<Order> orders = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");

            while (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                Order order = loadById(orderId);

                if (order != null) {
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
}
