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
import org.springframework.web.servlet.ModelAndView;

import com.amazon.inventory.model.Category;
import com.amazon.inventory.service.CategoryService;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    
    @GetMapping("/create-category")
    public String create_category(){
        return "create-category";
    }

    @GetMapping("/categories")
    public String categories(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @PostMapping("/createCategory")
    public ModelAndView createCategory(@ModelAttribute("Category") Category category,ModelAndView mav){
        category.setRecordCreated(new Date().toString());
        categoryService.createCategory(category);
        mav.addObject("categories", categoryService.getAllCategories());
        mav.setViewName("categories");
        return mav;
    }

    @GetMapping("/category/update/{id}")
    public String update_category_form(@PathVariable("id")long id,HttpSession session){
        session.setAttribute("category",categoryService.getCategoryById(id));
        return "redirect:/update-category";
    }

    @GetMapping("/update-category")
    public String update_category(){
        return "update-category";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@ModelAttribute("Category")Category category,Model model){
        categoryService.createCategory(category);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/category/delete/{id}")
    public String delete_category(@PathVariable("id")long id,Model model){
        categoryService.deleteCategory(id);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "redirect:/categories";
    }
}
