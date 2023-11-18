package com.amazon.inventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.inventory.model.Product;
import com.amazon.inventory.repository.ProductRepository;
import com.amazon.inventory.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(long id, long sellerId) {
        productRepository.deleteProductById(id, sellerId);
        
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteProductById(id);
        
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts(long sellerId) {
        return productRepository.getAllProductsBySellerId(sellerId);
    }

    @Override
    public Product getProductById(long id, long sellerId) {
        Optional<Product> product=productRepository.getProductById(id, sellerId);
        if(product.isPresent())
            return product.get();
        else
            return null;
    }

    @Override
    public Product updateProduct(Product product, long sellerId) {
        return productRepository.save(product);
    }
}
