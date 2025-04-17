package uz.usm.controller;

import uz.usm.model.Category;
import uz.usm.model.Product;

import java.util.List;

import static uz.usm.Main.*;

public class ProductController {
    public static void addProduct(){
        List<Category> allCategories = categoryService.getAllCategories();
        int ii = 1;
        for (Category allCategory : allCategories) {
            if(allCategory.getParent()==null){
                System.out.println(ii++ + ". " + allCategory.getName());
            }else{
                System.out.println("\t" + ii++ + ". " + allCategory.getName());
            }
        }
        int i1 = printInt("Enter your choice: ");
        if(i1>0 && i1<=allCategories.size()){
            Product product = new Product();
            product.setCategory(allCategories.get(i1-1));
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
        }else {
            System.out.println("Something Error ???");
        }

    }
    public static void showProducts(){
        List<Product> allProducts = productService.getAllProducts();
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }
}
