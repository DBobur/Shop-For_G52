package uz.usm.controller;

import uz.usm.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static uz.usm.Main.*;

public class CategoriesController {
    public static void addCategory() {
        System.out.print("""
                0. Back
                1. Choose Parent
                2. Continue 
                """);
        Category category = new Category();
        switch (printInt("Enter your choice: ")) {
            case -1 -> {
                System.out.println("\u001B[31m System Failure (Wrong Input).\u001B[0m");
            }
            case 0 -> { return; }
            case 1 -> {
                showHierarchy();
                String categoryName = printStr("Enter parent category name: ");
                category.setParentId(categoryService.getCategoryIdByName(categoryName));
            }
            default -> {
                System.out.println("\u001B[31m System Failure (Wrong Input).\u001B[0m");
                return;
            }
        }

        category.setName(printStr("Enter category name: "));
        category.setDescription(printStr("Enter category description: "));

        if (categoryService.addCategory(category)) {
            System.out.println("\u001B[32m System Success (Category Added).\u001B[0m");
        } else {
            System.out.println("\u001B[31m System Failure (Wrong Input).\u001B[0m");
        }
    }

    public static List<Category> showCategories(){
        int i = 1;
        for (Category category : categoryService.getAllCategories()) {
            if(category.getParentId()==null){
                System.out.println(i++ + ". " + category.getName());
            }else{
                System.out.println("\t" + i++ + ". " + category.getName());
            }
        }
        return categoryService.getAllCategories();
    }

    public static void showHierarchy(){
        List<Category> rootCategories = new ArrayList<>();
        for (Category category : categoryService.getAllCategories()) {
            if(category.getParentId()==null){
                rootCategories.add(category);
            }
        }
        int i = 1;
        for (Category category : rootCategories) {
            System.out.println(i++ + " " + category.getName());
            printChildren(category,"\t");
        }
    }


    private static void printChildren(Category category, String indent) {
        int i = 1;
        for (Category readCategory : categoryService.getAllCategories()) {
            if (Objects.equals(readCategory.getParentId(),category.getId())) {
                System.out.println(indent + "└ " + i++ + " " + readCategory.getName());
                printChildren(readCategory, indent + "\t");
            }
        }
    }
}
