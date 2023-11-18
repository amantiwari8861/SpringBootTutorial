package com.google.mypro.service;

import java.util.List;

import com.google.mypro.model.Product;

public interface ProductService {
    public List<Product> getAllProducts();
    public void createProduct(Product product);
}
