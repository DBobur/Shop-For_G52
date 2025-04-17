package uz.collections;

import uz.usm.model.User;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        show(list);
        show(list2);
        show(list3);
    }

    public static void show(List<?> list) {
     list.forEach(System.out::println);
    }
}
