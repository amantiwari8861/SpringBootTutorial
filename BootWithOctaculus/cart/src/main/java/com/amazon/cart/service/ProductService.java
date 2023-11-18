package com.amazon.cart.service;

import java.util.List;

import com.amazon.cart.model.Product;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product createProduct(Product product);
    public long countProducts();
}
