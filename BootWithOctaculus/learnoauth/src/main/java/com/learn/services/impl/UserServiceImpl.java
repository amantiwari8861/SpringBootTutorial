package com.learn.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.entities.User;
// import com.learn.repositories.RoleRepository;
import com.learn.repositories.UserRepository;
import com.learn.services.UserService;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository userRepo;
    // @Autowired
    // RoleRepository roleRepo;
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
		User user = this.userRepo.findByUsername(username).orElseThrow(()->new IllegalArgumentException());
		return user;
	}
    @Override
    public boolean saveUserWithRole(User user) {
    
        // roleRepo.saveAll(user.getRoles());
        // user.setRoles(null);
        userRepo.save(user);
        return true;
    }
}
