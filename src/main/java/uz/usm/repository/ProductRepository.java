package uz.usm.repository;

import uz.usm.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final String PRODUCT_FILE = "src/main/resources/products.txt";

    public boolean save(Product product) {
        List<Product> products = readProducts();
        products.add(product);
        return writeProducts(products);
    }

    public boolean writeProducts(List<Product> products) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PRODUCT_FILE))) {
            out.writeObject(products);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Product> readProducts() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PRODUCT_FILE))) {
            return (List<Product>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
