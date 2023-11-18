package com.learn.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.learn.entities.User;

public interface UserService extends UserDetailsService
{
    UserDetails loadUserByUsername(String username);
    boolean saveUserWithRole(User user);
}
