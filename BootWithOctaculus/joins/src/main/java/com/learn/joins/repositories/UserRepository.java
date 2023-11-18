package com.learn.joins.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.joins.models.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    
}
