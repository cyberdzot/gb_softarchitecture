package agregator;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<OrderItem> items;

    public Order(int id) {
        this.id = id;
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (OrderItem item : items) {
            totalCost += item.getProduct().getPrice() * item.getQuantity();
        }
        return totalCost;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }
}
