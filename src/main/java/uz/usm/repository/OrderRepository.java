package uz.usm.repository;

import uz.usm.model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static final String ORDER_FILE = "src/main/resources/orders.txt";

    public boolean save(Order order) {
        List<Order> orders = readOrders();
        orders.add(order);
        return writeOrders(orders);
    }

    public boolean writeOrders(List<Order> orders) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ORDER_FILE))) {
            out.writeObject(orders);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Order> readOrders() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ORDER_FILE))) {
            return (List<Order>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

}
