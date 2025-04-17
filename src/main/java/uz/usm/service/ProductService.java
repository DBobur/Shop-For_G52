package uz.usm.service;

import uz.usm.model.Product;
import uz.usm.repository.ProductRepository;

import java.util.List;

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
}
