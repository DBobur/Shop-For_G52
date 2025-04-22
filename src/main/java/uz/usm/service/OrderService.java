package uz.usm.service;

import uz.usm.model.Order;
import uz.usm.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService {
    private OrderRepository repository;
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public boolean addOrder(Order order) {
        return repository.save(order);
    }

    public List<Order> getAllOrders() {
        return repository.readOrders();
    }

    public List<Order> getOrdersByUserId(UUID userId) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : repository.readOrders()) {
            if(order.getUserId().equals(userId)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }
}
