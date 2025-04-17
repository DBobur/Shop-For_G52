package uz.usm.controller;

import uz.usm.model.Category;

import java.util.List;

import static uz.usm.Main.*;

public class CategoriesController {
    public static void addCategory(){
        System.out.print("0/1/2 -> (Back/Add Parent/Add Child)\n");
        int i = printInt("Enter your choice: ");
        Category category = new Category();
        if(i==0){ return;}
        else if(i==1){
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
                category.setParent(allCategories.get(i1-1));
            }else {
                System.out.println("Something Error ???");
            }

        }
        else if(i!=2){
            System.out.println("Invalid choice");
            return;
        }
        System.out.print("Enter Category Name: ");
        category.setName(scStr.nextLine());
        System.out.print("Enter Category Description: ");
        category.setDescription(scStr.nextLine());
        if (categoryService.addCategory(category)) {
            System.out.println("Category added");
        }else{
            System.out.println("Category not added");
        }

    }
    public static void showCategories(){
        List<Category> allCategories = categoryService.getAllCategories();
        int i = 1;
        for (Category category : allCategories) {
            System.out.println(i++ + ". " + category.getName());
        }
    }
}
