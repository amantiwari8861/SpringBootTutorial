package com.learn.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>
{
    Optional<User> findByUsername(String username);
}
