package com.learn.manytomany.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.manytomany.models.Role;
import com.learn.manytomany.models.User;
import com.learn.manytomany.repositories.UserRepository;

@Controller
public class MainController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registerUser")
    public String reg()
    {
        return "register";
    }

    @PostMapping("/registerUser")
    public String register(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("role")String role,Model model)
    {
        System.out.println("in /register url -------"+role+"-------");
		model.addAttribute("msg", "unable to Register !!");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		Set<Role> roles=new HashSet<>();

		for (String rString : role.split(",")) 
		{
			if(rString.equals("ROLE_ADMIN"))
			{
				roles.add(new Role(1,"ROLE_ADMIN"));
			}
			if(rString.equals("ROLE_MANAGER"))
			{
				roles.add(new Role(2,"ROLE_MANAGER"));
			}
			if(rString.equals("ROLE_USER"))
			{
				roles.add(new Role(3, "ROLE_USER"));
			}
		}
		user.setRoles(roles);
		System.out.println(user);
        userRepository.save(user);
		model.addAttribute("msg", "Registered Succesfully!!");
        
        return "register";
    }
}
