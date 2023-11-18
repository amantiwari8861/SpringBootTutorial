package com.amazon.inventory.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amazon.inventory.model.Category;
import com.amazon.inventory.model.SubCategory;
import com.amazon.inventory.service.CategoryService;
import com.amazon.inventory.service.SubCategoryService;

@Controller
public class SubCategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;
    
    @GetMapping("/create-sub-category")
    public String create_sub_category(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "create-sub-category";
    }

    @PostMapping("/createSubCategory")
    public String createSubCategory(@ModelAttribute("SubCategory")SubCategory subCategory,HttpSession session){
        subCategory.setRecordCreated(new Date().toString());
        subCategoryService.createSubCategory(subCategory);
        session.setAttribute("sub_categories", subCategoryService.getAllSubCategories());
        return "sub-categories";
    }

     @GetMapping("/sub-category/update/{id}")
    public String update_sub_category_form(@PathVariable("id")long id,HttpSession session){
        session.setAttribute("sub-category",subCategoryService.getSubCategoryById(id));
        return "redirect:/update-sub-category";
    }

    @GetMapping("/update-sub-category")
    public String update_sub_category(){
        return "update-sub-category";
    }

    @PostMapping("/updateSubCategory")
    public String updateSubCategory(@ModelAttribute("Category")Category category,Model model){
        categoryService.createCategory(category);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/sub-category/delete/{id}")
    public String delete_sub_category(@PathVariable("id")long id,Model model){
        categoryService.deleteCategory(id);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "redirect:/categories";
    }
}
