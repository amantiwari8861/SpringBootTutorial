package com.google.mypro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    
    @GetMapping("/products-list")
    public String products_list(){
        return "products-list";
    }

    @GetMapping("/create-product")
    public String create_product(){
        return "create-product";
    }
}
