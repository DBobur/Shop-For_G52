package uz.usm;

import uz.usm.model.User;
import uz.usm.model.enums.UserRole;
import uz.usm.repository.CategoryRepository;
import uz.usm.repository.OrderRepository;
import uz.usm.repository.ProductRepository;
import uz.usm.repository.UserRepository;
import uz.usm.service.CategoryService;
import uz.usm.service.OrderService;
import uz.usm.service.ProductService;
import uz.usm.service.UserService;

import java.util.Scanner;
import static uz.usm.controller.UserController.*;

public class Main {
    public static Scanner scInt = new Scanner(System.in);
    public static Scanner scStr = new Scanner(System.in);

    private UserRepository userRepository = new UserRepository();
    public static UserService userService = new UserService(new UserRepository());
    private static CategoryRepository categoryRepository = new CategoryRepository();
    public static CategoryService categoryService = new CategoryService(categoryRepository);
    private ProductRepository productRepository = new ProductRepository();
    public static ProductService productService = new ProductService(new ProductRepository());
    private OrderRepository orderRepository = new OrderRepository();
    public static OrderService orderService = new OrderService(new OrderRepository());

    public static User currentUser = null;

    static {
        User admin = new User(
                 "admin",
                "admin",
                "admin");
        admin.setRole(UserRole.ADMIN_ROLE);
        userService.addUser(admin);
    }

    public static void main(String[] args) {
        while (true){
            System.out.println("""
                    1.Login
                    2.Register
                    0.Exit
                    """);

            switch (printInt("Enter your choice: ")) {
                case -1 -> { System.out.println("Wrong input"); }
                case 0 -> { return; }
                case 1 -> { myLogin(); }
                case 2 -> { myRegister(); }
                default -> System.out.println("Wrong choice");
            }
        }
    }

    public static int printInt(String s) {
        try {
            System.out.print(s);
            return scInt.nextInt();
        }catch (Exception e){
            scInt = new Scanner(System.in);
            return -1;
        }

    }

    public static double printDouble(String s) {
        try {
            System.out.print(s);
            return scInt.nextDouble();
        }catch (Exception e){
            scInt = new Scanner(System.in);
            return -1;
        }

    }

    public static String printStr(String s) {
        System.out.print(s);
        return scStr.nextLine();
    }
}