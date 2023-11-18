package com.amazon.inventory.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amazon.inventory.model.Product;
import com.amazon.inventory.model.SubCategory;
import com.amazon.inventory.service.CategoryService;
import com.amazon.inventory.service.CommentsService;
import com.amazon.inventory.service.ProductService;
import com.amazon.inventory.service.SubCategoryService;

@Controller
public class ProductController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    ProductService productService;

    @Autowired
    CommentsService commentsService;
    
    @GetMapping("/add-product/{sub_category}")
    public String add_product_mobile(@PathVariable("sub_category")String sub_category,Model model){
        System.out.println(sub_category);
        boolean isFound=false;
        List<SubCategory> sub_categories=subCategoryService.getAllSubCategories();
        
        System.out.println(sub_categories);
        for(SubCategory sub_cat:sub_categories){
            System.out.print(sub_cat.getSubCategoryName());
            if(sub_cat.getSubCategoryName().equalsIgnoreCase(sub_category.trim())){
                isFound=true;
                break;
            }
        }

        // Extract subCategoryName values and join them into a comma-separated string
        String subCategoryNames = sub_categories.stream()
                .map(SubCategory::getSubCategoryName)
                .collect(Collectors.joining(", "));

        if(isFound==false){
            model.addAttribute("error", "The category "+sub_category.trim()+" is not available.<br>You can only choose one of the following categories - "+subCategoryNames);
            return "add-product";
        }

        if(sub_category.trim().length()==0)
            model.addAttribute("product_type", null);
        else
            model.addAttribute("product_type", sub_category.trim());

        model.addAttribute("categories", categoryService.getAllCategories());
        return "/add-product";
    }

    @GetMapping("/add-product-with-category")
    public String add_product_with_category(){
        return "add-product";
    }

    @GetMapping("/add-product")
    public String add_product_view(Model model){
        // session.removeAttribute("product_type");
        model.addAttribute("product_type", null);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "add-product";
    }

    @GetMapping("/products")
    public String products(HttpSession session){
        session.setAttribute("products", productService.getAllProducts(5));
        return "products";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("Product")Product product,HttpSession session){
        product.setRecordCreated(new Date().toString());
        product.setSellerId(5);
        product.setCategory(subCategoryService.getSubCategoryByName(product.getSubCategory()));
        productService.createProduct(product);
        session.setAttribute("products", productService.getAllProducts(5));
        return "redirect:/products";
    }

    // @GetMapping("/mobile/{id}")
    // public String mobile(@PathVariable("id")long id,Model model){
    //     Mobile mobile=productService.getProductById(id, 5);
    //     if(mobile==null)
    //     return "/error";
        
    //     model.addAttribute("mobile", mobile);
    //     return "mobile";
    // }

    @GetMapping("/product/delete/{sellerId}/{id}")
    public String delete_product(@PathVariable("sellerId")long sellerId,@PathVariable("id")long id,HttpSession session){
        productService.deleteProductById(id, sellerId);
        session.setAttribute("products", productService.getAllProducts(5));
        return "redirect:/products";
    }

    @GetMapping("/product/view/{sellerId}/{id}")
    public String view_product(@PathVariable("sellerId")long sellerId,@PathVariable("id")long id,HttpSession session){
        session.setAttribute("product", productService.getProductById(id, sellerId));
        session.setAttribute("comments", commentsService.getAllCommentsByProductId(id));
        return "redirect:/view-product";
    }

    @GetMapping("/view-product")
    public String view_product(){
        return "view-product";
    }

    // @GetMapping("/mobile/update/{sellerId}/{id}")
    // public String update_mobile_request(@PathVariable("sellerId")long sellerId,@PathVariable("id")long id,HttpSession session){
    //     session.setAttribute("mobile", mobileService.getMobileById(id, sellerId));
    //     return "redirect:/update-mobile";
    // }

    // @GetMapping("/update-mobile")
    // public String update_mobile_form(){
    //     return "update-mobile";
    // }

    // @PostMapping("/updateMobile")
    // public String update_mobile(@ModelAttribute("Mobile")Mobile mobile,Model model){
    //     mobileService.createMobile(mobile);
    //     model.addAttribute("mobiles", mobileService.getAllMobiles(mobile.getSellerId()));
    //     return "mobile-list";
    // }
}
