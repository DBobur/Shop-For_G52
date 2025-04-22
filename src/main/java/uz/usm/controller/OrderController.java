package uz.usm.controller;

import uz.usm.model.Order;
import uz.usm.model.Product;
import uz.usm.model.enums.OrderStatus;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static uz.usm.Main.*;

public class OrderController {

    public static void showOrders() {
        List<Order> orders = orderService.getOrdersByUserId(currentUser.getId());
        int i = 1;
        for (Order order : orders) {
            Map<UUID, Integer> products = order.getProducts();
            System.out.println("Order #" + i++ + ": " + order.getStatus());
            int i1 = 1;
            for (Map.Entry<UUID, Integer> uuidIntegerEntry : products.entrySet()) {
                Product productById = productService.getProductById(uuidIntegerEntry.getKey());
                System.out.print("\torder #" + i1++ + ": ");
                System.out.println(
                        productById.getName() + " "
                                + uuidIntegerEntry.getValue());
            }
        }
    }

    public static void acceptedOrders() {
        List<Order> orders = orderService.getOrdersByStatus(OrderStatus.NEW);
        int i = 1;
        for (Order order : orders) {
            System.out.println("Order #" + i++ + ": " + order);
        }
        int choice = printInt("Pick one order to accept: ");
        if (choice>=1 && choice<=orders.size()) {
            orderService.accepted(orders.get(choice-1));
        }else {
            System.out.println("Wrong choice");
        }
    }

}
