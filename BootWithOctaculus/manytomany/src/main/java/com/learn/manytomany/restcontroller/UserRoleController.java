package com.learn.manytomany.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.manytomany.models.Role;
import com.learn.manytomany.models.User;
import com.learn.manytomany.repositories.RoleRepository;
import com.learn.manytomany.repositories.UserRepository;

@RestController
@RequestMapping("/user/role")
public class UserRoleController 
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    public UserRoleController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostMapping
    public User saveUserWithRole(@RequestBody User user)
    {
        return userRepository.save(user);
    }
    @GetMapping("/allusers")
    public List<User> findAllUser()
    {
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public User findUser(int id)
    {
        return userRepository.findById(id).orElse(null);
    }
    @GetMapping("/find/{username}")
    public List<User> findUsersContainingByUsername(@PathVariable String username)
    {
        return userRepository.findByUsernameContaining(username);
    }
    @GetMapping("/search/{rolename}")
    public List<Role> findByRoleName(@PathVariable String rolename)
    {
        return roleRepository.findByRoleName(rolename);
    }
}
