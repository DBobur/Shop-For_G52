package uz.usm;

import uz.usm.model.User;
import uz.usm.model.enums.UserRole;
import uz.usm.repository.UserRepository;
import uz.usm.service.UserService;

import java.util.Scanner;
import static uz.usm.controller.UserController.*;

public class Main {
    public static Scanner scInt = new Scanner(System.in);
    public static Scanner scStr = new Scanner(System.in);

    private UserRepository userRepository = new UserRepository();
    public static UserService userService = new UserService(new UserRepository());

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
            System.out.print("Enter your choice: ");
            int choice = scInt.nextInt();
            switch (choice) {
                case 1 -> {
                    myLogin();
                }
                case 2 -> {
                    myRegister();
                }
                case 0 -> { return; }
            }
        }
    }
}