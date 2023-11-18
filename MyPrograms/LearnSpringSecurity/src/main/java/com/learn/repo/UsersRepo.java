package com.learn.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.bean.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users,Long>
{
    Optional<Users> findByUserName(String userName);   
}
