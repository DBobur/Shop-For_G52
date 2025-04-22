package uz.usm.controller;

import uz.usm.model.Order;
import uz.usm.model.Product;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static uz.usm.Main.*;

public class OrderController {

    public static void showOrders(){
        List<Order> orders = orderService.getOrdersByUserId(currentUser.getId());
        int i = 1;
        for (Order order : orders) {
            Map<UUID, Integer> products = order.getProducts();
            for (Map.Entry<UUID, Integer> uuidIntegerEntry : products.entrySet()) {
                Product productById = productService.getProductById(uuidIntegerEntry.getKey());
                System.out.print("order #" + i++ + ": " );
                System.out.println(productById.getName() + " " + uuidIntegerEntry.getValue());
            }
        }
    }

}
