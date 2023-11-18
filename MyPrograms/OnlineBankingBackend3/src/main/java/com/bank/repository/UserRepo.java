package com.bank.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>
{
	Optional<User> findByEmail(String username);
}
