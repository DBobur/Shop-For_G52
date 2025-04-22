package uz.usm.controller;

import uz.usm.model.User;

import java.util.List;

import static uz.usm.Main.*;
import static uz.usm.controller.CategoriesController.*;
import static uz.usm.controller.ProductController.*;
import static uz.usm.controller.OrderController.*;

public class UserController {
    public static void myLogin() {
        System.out.print("Enter your username: ");
        String username = scStr.nextLine();
        System.out.print("Enter your password: ");
        String password = scStr.nextLine();

        currentUser = userService.login(username,password);
        if(currentUser != null){
            switch (currentUser.getRole()){
                case USER_ROLE -> userMenu();
                case ADMIN_ROLE -> adminMenu();
            }
        }else {
            System.out.println("Invalid username or password");
        }
    }

    private static void userMenu() {
        System.out.println("Welcome " + currentUser.getName());
        while (true){
            System.out.println("""
                    1. Buy products
                    2. Search product
                    3. Search products by category
                    4. Show Orders
                    5. Show History
                    0. Log out
                    """);
            switch (printInt("Enter your choice: ")){
                case -1 -> { System.out.println("Wrong input"); }
                case 0 -> { return; }
                case 1 -> {
                    buyProducts();
                }
                case 4 -> {
                    showOrders();
                }
                default -> System.out.println("Wrong choice");
            }
        }
    }

    private static void adminMenu() {
        System.out.println("Welcome " + currentUser.getName() + " !!!");
        while (true){
            System.out.println("""
                    1. Add Product
                    2. Add Category
                    3. Show Categories
                    4. Show Products
                    5. Show Users
                    6. Accepted Orders
                    0. Log out
                    """);
            switch (printInt("Enter your choice: ")){
                case -1 -> { System.out.println("Wrong input"); }
                case 0 -> { return; }
                case 1 -> { addProduct(); }
                case 2 -> { addCategory(); }
                case 3 -> {
                    //showCategories();
                    showHierarchy();
                }
                case 4 -> { showProducts(); }
                case 5 -> {
                    List<User> allUsers = userService.getAllUsers();
                    for (User allUser : allUsers) {
                        System.out.println(allUser);
                    }
                }
                case 6 -> {
                    acceptedOrders();
                }
                default -> System.out.println("Wrong choice");
            }
        }
    }

    public static void myRegister() {
        String name = printStr("Enter your name: ");
        String username = printStr("Enter your username: ");
        String password = printStr("Enter your password: ");
        User user = new User(name, username, password);
        if (userService.addUser(user)) {
            System.out.println("User added");
        }else {
            System.out.println("User not added");
        }
    }
}
