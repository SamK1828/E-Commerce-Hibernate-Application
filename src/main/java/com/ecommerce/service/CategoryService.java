package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Category;

public interface CategoryService {
    Category createCategory(Category category);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    Category updateCategory(Category category);
    boolean deleteCategory(Long id);
}
