package uz.usm.controller;

import uz.usm.model.Order;
import uz.usm.model.Product;

import java.util.*;

import static uz.usm.Main.*;
import static uz.usm.controller.CategoriesController.showHierarchy;

public class ProductController {
    public static void addProduct(){
        showHierarchy();
        UUID cId = categoryService.getCategoryIdByName(printStr("Enter category name: "));
        if(cId == null){
            System.out.println("Wrong input");
            return;
        }
        Product product = new Product();
        product.setCategoryId(cId);
        product.setName(printStr("Enter name: "));
        product.setDescription(printStr("Enter description: "));
        product.setPrice(printDouble("Enter price: "));
        product.setQuantity(printInt("Enter quantity: "));
        product.setOwnerId(currentUser.getId());
        if (productService.addProduct(product)) {
            System.out.println("Product added");
        }else{
            System.out.println("Product not added");
        }

    }
    public static void showProducts(){
        List<Product> allProducts = productService.getAllProducts();
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }

    public int fibonacci(int n){
        if(n <= 1){
            return 0;
        }else if(n == 2){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static void buyProducts(){
        Order currentOrder = null;
        while (true) {
            showHierarchy();
            UUID cId = categoryService.getCategoryIdByName(printStr("Enter category name: "));
            if (cId == null) {
                System.out.println("Wrong input");
                return;
            }
            int i = 1;
            List<Product> productsByCategory = productService.getProductsByCategory(cId);
            for (Product product : productsByCategory) {
                System.out.println(i++ + ". " + product);
            }

            String s = printStr("Do you want to buy a product? (y/n)");
            if (s.equalsIgnoreCase("y")) {
                if (currentOrder == null) { currentOrder = new Order(); }
                int i1 = printInt("Enter product number: ");
                if(i1<1 || i1>productsByCategory.size()){ continue; }
                Product product = productsByCategory.get(i1 - 1);
                int i2 = printInt("Enter product quantity: ");
                if(i2>product.getQuantity()){
                    continue;
                }else {
                    currentOrder.setUserId(currentUser.getId());
                    Map<UUID, Integer> products = currentOrder.getProducts();
                    if(products == null){ products = new HashMap<>(); }
                    products.put(product.getId(), i2);
                    currentOrder.setProducts(products);
                }
                s = printStr("Would you like to buy another product? (y/n)");
                if (!s.equalsIgnoreCase("y")) {
                    if(orderService.addOrder(currentOrder)){
                        System.out.println("Order added");
                    }else {
                        System.out.println("Order not added");
                    }
                    return;
                }
            }else {
                return;
            }
        }
    }
}
