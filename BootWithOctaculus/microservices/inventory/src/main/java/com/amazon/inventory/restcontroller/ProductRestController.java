package com.amazon.inventory.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.inventory.model.Product;
import com.amazon.inventory.service.ProductService;

@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;
    
    @GetMapping("/rest/product/view/{id}")
    public Product view_product_by_id(@PathVariable("id")long id){
        Product product=productService.getProductById(id);
        System.out.println(product);
        return product;
    }

    @DeleteMapping("/rest/product/delete/{id}")
    public void delete_product_by_id(@PathVariable("id")long id){
        productService.deleteProductById(id);
    }

    @PutMapping("/rest/product/update/{id}")
    public Product update_product(@RequestBody Product product){
        productService.createProduct(product);
        return product;
    }

    @PostMapping("/rest/create-product")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

}
