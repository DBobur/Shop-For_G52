package uz.usm.service;

import uz.usm.model.Category;
import uz.usm.repository.CategoryRepository;

import java.util.List;
import java.util.UUID;

public class CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public boolean addCategory(Category category) {
        if(checkCategory(category.getName())){
            return false;
        }
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.readCategories();
    }

    private boolean checkCategory(String name) {
        List<Category> categories = categoryRepository.readCategories();
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public UUID getCategoryByName(String categoryName) {
        for (Category category : categoryRepository.readCategories()) {
            if (category.getName().equals(categoryName)) {
                return category.getId();
            }
        }
        return null;
    }
}
