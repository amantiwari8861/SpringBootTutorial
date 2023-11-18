package com.amazon.inventory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amazon.inventory.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    
    @Query("from Product where sellerId=?1")
    public List<Product> getAllProductsBySellerId(long sellerId);

    @Query("from Product where id=?1 and sellerId=?2")
    public Optional<Product> getProductById(long id,long sellerId);

    @Query("from Product where id=?1")
    public Product getProductById(long id);

    @Transactional
    @Modifying
    @Query("delete from Product where id=?1 and sellerId=?2")
    public void deleteProductById(long id,long sellerId);

    @Transactional
    @Modifying
    @Query("delete from Product where id=?1")
    public void deleteProductById(long id);
}
