package uz.usm.controller;

import uz.usm.model.User;
import static uz.usm.Main.*;

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
    }

    private static void adminMenu() {
        System.out.println("Welcome " + currentUser.getName());
    }

    public static void myRegister() {
        System.out.print("Enter your name: ");
        String name = scStr.nextLine();
        System.out.print("Enter your username: ");
        String username = scStr.nextLine();
        System.out.print("Enter your password: ");
        String password = scStr.nextLine();
        User user = new User(name, username, password);
        if (userService.addUser(user)) {
            System.out.println("User added");
        }else {
            System.out.println("User not added");
        }
    }
}
