package uz.collections;

import uz.usm.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            users.add(new User("" + i, "" + i, "" + i));
        }
        System.out.println("In ArrayList");
        System.out.println(System.currentTimeMillis() - l);

        LinkedList<User> users2 = new LinkedList<>();
        l = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            users2.add(new User("" + i, "" + i, "" + i));
        }
        System.out.println("In LinkedList");
        System.out.println(System.currentTimeMillis() - l);

        Set<User> set = new HashSet<>();
        l = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            set.add(new User("" + i, "" + i, "" + i));
        }
        System.out.println("In HashSet");
        System.out.println(System.currentTimeMillis() - l);
    }
}
