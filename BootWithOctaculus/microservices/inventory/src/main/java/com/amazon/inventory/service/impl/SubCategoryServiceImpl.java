package com.amazon.inventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.inventory.model.SubCategory;
import com.amazon.inventory.repository.SubCategoryRepository;
import com.amazon.inventory.service.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{


    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Override
    public SubCategory createSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public void deleteSubCategory(long id) {
        subCategoryRepository.deleteById(id);
    }

    @Override
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory getSubCategoryById(long id) {
        Optional<SubCategory> subCategory=subCategoryRepository.findById(id);
        if(subCategory.isPresent())
            return subCategory.get();
        else
            return null;
    }

    @Override
    public SubCategory updateSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public String getSubCategoryByName(String name) {
        SubCategory sub_category=subCategoryRepository.getSubCategoryByName(name);
        return sub_category.getCategoryName();
    }
}
