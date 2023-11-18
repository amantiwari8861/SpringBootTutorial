package com.google.mypro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.mypro.model.Product;
import com.google.mypro.repository.ProductRepository;
import com.google.mypro.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);        
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
