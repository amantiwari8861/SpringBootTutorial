package com.amazon.inventory.service;

import java.util.List;

import com.amazon.inventory.model.SubCategory;

public interface SubCategoryService {
    public List<SubCategory> getAllSubCategories();
    public void deleteSubCategory(long id);
    public SubCategory createSubCategory(SubCategory subCategory);
    public SubCategory updateSubCategory(SubCategory subCategory);
    public SubCategory getSubCategoryById(long id);
    public String getSubCategoryByName(String name);
}
