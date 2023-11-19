package com.learn.manytomany.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.manytomany.models.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    
    List<User> findByUsernameContaining(String username);
}
