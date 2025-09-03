package com.ecommerce.service.impl;

import java.util.List;

import com.ecommerce.dao.DAOCategory;
import com.ecommerce.entity.Category;
import com.ecommerce.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    private final DAOCategory categoryDao;

    public CategoryServiceImpl(DAOCategory categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category createCategory(Category category) {
        categoryDao.saveCategory(category);
        return category;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public List<Category> getAllCategories() {

        throw new UnsupportedOperationException("Unimplemented method 'getAllCategories'");
    }

    @Override
    public Category updateCategory(Category category) {
        categoryDao.updateCategory(category);
        return category; // return updated object
    }

    @Override
    public boolean deleteCategory(Long id) {
        Category category = categoryDao.getCategoryById(id);
        if (category != null) {
            categoryDao.deleteCategory(category);
            return true;
        }
        return false;

    }

}