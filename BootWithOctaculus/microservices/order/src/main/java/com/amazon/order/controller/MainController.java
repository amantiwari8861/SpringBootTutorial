package com.amazon.order.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.amazon.order.general.Product;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/product/{id}")
    public String view_product(@PathVariable("id")long id,HttpSession session){
        RestTemplate restTemplate=new RestTemplate();
        //session.setAttribute("product", restTemplate.getForObject("http://localhost:8080/rest/product/view/"+id, Product.class));
        ResponseEntity<Product> product;
        product=restTemplate.getForEntity("http://localhost:8080/rest/product/view/"+id, Product.class);
        session.setAttribute("product", product.getBody());
        return "product";
    }

    @GetMapping("/delete/product/{id}")
    public String delete_product(@PathVariable("id")long id,HttpSession session){
        RestTemplate restTemplate=new RestTemplate();
        //session.setAttribute("product", restTemplate.getForObject("http://localhost:8080/rest/product/delete/"+id, Product.class));
        restTemplate.delete("http://localhost:8080/rest/product/delete/"+id);
        return "index";
    }

    @GetMapping("/update/product/{id}")
    public String update_product(@PathVariable("id")long id){
        RestTemplate restTemplate=new RestTemplate();
        Product product=restTemplate.getForObject("http://localhost:8080/rest/product/view/"+id, Product.class);
        if(product!=null)
        {
            product.setMrp(99999);
            restTemplate.put("http://localhost:8080/rest/product/update/{id}", product,Product.class);
        }
        return "index";
    }
    @GetMapping("/create/product")
    public String createProduct(){
        RestTemplate restTemplate=new RestTemplate();
        Product product=new Product();
        product.setMrp(123456);
        product.setPrice(9999);
        product.setBrand("Samsung");
        product.setProductTitle("samsung Galaxy Note");
        product.setRecordCreated(new Date().toString());
        restTemplate.postForObject("http://localhost:8080/rest/create-product", product, Product.class);
        return "index";
    }
    
}
