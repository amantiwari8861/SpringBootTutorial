package com.google.drive.service;

import java.util.List;
import java.util.Optional;

import com.google.drive.model.User;

public interface UserService {
    public User getUserByEmailAndPassword(String email,String password);
    public List<User> getUsersByIds(long start,long end);
    public void createUser(User user);
    public void deleteUserById(long id);
    public List<User> getAllUsers();
    public Optional<User> findById(long id);
}
