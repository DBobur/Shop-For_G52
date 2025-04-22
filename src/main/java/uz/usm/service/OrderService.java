package uz.usm.service;

import uz.usm.model.Order;
import uz.usm.model.enums.OrderStatus;
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

    public List<Order> getOrdersByStatus(OrderStatus orderStatus) {
        List<Order> orders = new ArrayList<>();
        for (Order order : repository.readOrders()) {
            if (order.getStatus() == orderStatus) {
                orders.add(order);
            }
        }
        return orders;
    }

    public void accepted(Order order) {
        List<Order> orders = repository.readOrders();
        for (Order order1 : orders) {
            if(order1.getId().equals(order.getId())) {
                order1.setStatus(OrderStatus.BUYING);
                repository.writeOrders(orders);
                break;
            }
        }
    }
}
