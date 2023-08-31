package repository;

import agregator.Order;

import java.util.List;

public interface OrderRepository {
    void save(Order order);

    Order loadById(int orderId);

    List<Order> loadAll();
}
