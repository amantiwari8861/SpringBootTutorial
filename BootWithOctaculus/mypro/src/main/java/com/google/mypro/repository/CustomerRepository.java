package com.google.mypro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.mypro.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    
}
