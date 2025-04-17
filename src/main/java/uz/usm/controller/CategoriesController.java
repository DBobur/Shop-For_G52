package uz.usm.controller;

import uz.usm.model.Category;

import static uz.usm.Main.*;

public class CategoriesController {
    public static void addCategory(){
        System.out.print("0");
        Category category = new Category();
        System.out.print("Enter Category Name: ");
        category.setName(scStr.nextLine());
        System.out.print("Enter Category Description: ");
        category.setDescription(scStr.nextLine());

    }
    public static void showCategories(){}
}
