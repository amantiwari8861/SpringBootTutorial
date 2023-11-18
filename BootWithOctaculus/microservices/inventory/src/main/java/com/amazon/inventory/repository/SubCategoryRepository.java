package com.amazon.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amazon.inventory.model.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long>{
    @Query("from SubCategory where subCategoryName=?1")
    public SubCategory getSubCategoryByName(String name);
}
