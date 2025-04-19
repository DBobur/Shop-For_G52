package uz.usm.controller;

import uz.usm.model.Product;

import java.util.List;
import java.util.UUID;

import static uz.usm.Main.*;
import static uz.usm.controller.CategoriesController.showHierarchy;

public class ProductController {
    public static void addProduct(){
        showHierarchy();
        UUID cId = categoryService.getCategoryByName(printStr("Enter category name: "));
        if(cId == null){
            System.out.println("Wrong input");
            return;
        }
        Product product = new Product();
        product.setCategoryId(cId);
        product.setName(printStr("Enter name: "));
        product.setDescription(printStr("Enter description: "));
        product.setPrice(printDouble("Enter price: "));
        product.setQuantity(printInt("Enter quantity: "));
        product.setOwnerId(currentUser.getId());
        if (productService.addProduct(product)) {
            System.out.println("Product added");
        }else{
            System.out.println("Product not added");
        }

    }
    public static void showProducts(){
        List<Product> allProducts = productService.getAllProducts();
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }
}
