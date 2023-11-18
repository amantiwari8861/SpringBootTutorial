package com.google.drive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.google.drive.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    @Query("from User where id between ?1 and ?2")
    public List<User> getUsersByIds(long start,long end);
    
    @Query("from User where email=?1 and password=?2")
    public User getUserByEmailAndPassword(String email,String password);
}
