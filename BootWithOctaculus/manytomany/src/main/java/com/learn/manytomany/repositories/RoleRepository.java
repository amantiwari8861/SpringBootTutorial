package com.learn.manytomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.manytomany.models.Role;
import java.util.List;


public interface RoleRepository extends JpaRepository<Role,Integer>{
    
    List<Role> findByRoleName(String roleName);
}
