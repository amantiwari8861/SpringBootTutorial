package com.google.mypro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.mypro.service.CustomerService;
import com.google.mypro.service.ProductService;

@Controller
public class URLController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;
    
    @RequestMapping(value="/" , method = RequestMethod.GET)
    public String index(Model model){
        customerService.createCustomer(null);
        productService.createProduct(null);
        model.addAttribute("customer", "costomer data");
        model.addAttribute("product", "product data");
        return "index";
    }
}
