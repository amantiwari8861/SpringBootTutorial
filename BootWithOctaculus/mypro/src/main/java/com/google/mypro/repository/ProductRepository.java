package com.google.mypro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.mypro.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
