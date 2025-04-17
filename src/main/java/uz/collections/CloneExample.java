package uz.collections;

import uz.usm.model.User;

public class CloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        User u1 = new User("BD","bobur","0320");
        User u2 = u1.clone();
        u2.setUsername("muhammad");
        System.out.println(u1);
        System.out.println(u2);

    }
}
