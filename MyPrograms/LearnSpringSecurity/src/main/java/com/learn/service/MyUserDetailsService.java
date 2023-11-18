package com.learn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.bean.MyUserDetails;
import com.learn.bean.Users;
import com.learn.repo.UsersRepo;

// import com.learn.bean.User;
@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
    UsersRepo usersRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        // return new User(username);
        Optional<Users> users=usersRepo.findByUserName(username);
        users.orElseThrow(()->new UsernameNotFoundException("Username Not Found"));
       return users.map(MyUserDetails::new).get();
    }
    
}
