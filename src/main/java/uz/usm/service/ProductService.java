package uz.usm.service;

import com.sun.source.tree.Tree;
import com.sun.source.util.Trees;
import uz.usm.model.Product;
import uz.usm.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductService {
    private ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public boolean addProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.readProducts();
    }

    public List<Product> getProductsByCategory(UUID categoryId) {
        List<Product> products = repository.readProducts();
        List<Product> categoryProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategoryId().equals(categoryId)) {
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }
}
