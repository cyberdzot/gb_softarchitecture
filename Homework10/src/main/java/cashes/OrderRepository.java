package cashes;

import agregator.Order;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class OrderRepository {
    private Cache<Integer, Order> orderCache;

    public OrderRepository() {
        orderCache = CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS) // Время жизни элемента в кэше
                .maximumSize(100) // Максимальное количество элементов в кэше
                .build();
    }

    public Order getOrder(int id) {
        Order order = orderCache.getIfPresent(id);
        if (order == null) {
            order = loadOrderFromDatabase(id);
            orderCache.put(id, order);
        }
        return order;
    }

    private Order loadOrderFromDatabase(int id) {
        // Загрузка заказа из базы данных
        return null;
    }

    public void updateOrder(Order order) {
        // Обновление заказа в базе данных
        orderCache.put(order.getId(), order);
    }
}
