package com.amazon.inventory.service;

import java.util.List;

import com.amazon.inventory.model.Product;

public interface ProductService {
    public List<Product> getAllProducts(long sellerId);
    public Product getProductById(long id,long sellerId);
    public void deleteProductById(long id,long sellerId);
    public Product createProduct(Product product);
    public Product updateProduct(Product product,long sellerId);
}
