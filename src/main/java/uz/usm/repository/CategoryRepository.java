package uz.usm.repository;

import uz.usm.model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private static final String CATEGORY_FILE = "src/main/resources/categories.txt";

    public boolean save(Category category) {
        List<Category> categories = readCategories();
        categories.add(category);
        return writeUsers(categories);
    }

    public boolean writeUsers(List<Category> categories) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CATEGORY_FILE))) {
            out.writeObject(categories);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Category> readCategories() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(CATEGORY_FILE))) {
            return (List<Category>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
