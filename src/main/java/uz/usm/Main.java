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
    public static String printStr(String s) {
        System.out.print(s);
        return scInt.nextLine();
    }
}