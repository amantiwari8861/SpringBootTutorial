package com.amazon.inventory.service;

import java.util.List;

import com.amazon.inventory.model.Category;

public interface CategoryService {
    public List<Category> getAllCategories();
    public void deleteCategory(long id);
    public Category createCategory(Category category);
    public Category updateCategory(Category category);
    public Category getCategoryById(long id);
}
