package com.learn.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.config.security.jwt.JwtTokenHelper;
// import com.learn.entities.Role;
import com.learn.entities.User;
import com.learn.payloads.JwtAuthRequest;
import com.learn.payloads.JwtAuthResponse;
import com.learn.repositories.UserRepository;
import com.learn.services.UserService;

@Controller
public class JwtLoginController {
    
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
    @PostMapping("/registerUser")
    public String reg(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("role")String roles,Model model )
    {
		System.out.println("in /register url -------"+roles+"-------");
		model.addAttribute("msg", "unable to Register !!");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		// Set<Role> roles=new HashSet<>();
		// for (String rString : role.split(",")) 
		// {
		// 	if(rString.equals("ROLE_ADMIN"))
		// 	{
		// 		roles.add(new Role(1,"ROLE_ADMIN"));
		// 	}
		// 	if(rString.equals("ROLE_MANAGER"))
		// 	{
		// 		roles.add(new Role(2,"ROLE_MANAGER"));
		// 	}
		// 	if(rString.equals("ROLE_USER"))
		// 	{
		// 		roles.add(new Role(3, "ROLE_USER"));
		// 	}
		// }
		user.setRoles(roles);
		System.out.println(user);
		userService.saveUserWithRole(user);
		model.addAttribute("msg", "Registered Succesfully!!");
        return "register";
    }
	
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(
			@RequestBody JwtAuthRequest request
			)
	{
		System.out.println(request);
		this.authenticate(request.getUsername(),request.getPassword());
		UserDetails loadUserByUsername = userService.loadUserByUsername(request.getUsername());
		String token = jwtTokenHelper.generateToken(loadUserByUsername);
		JwtAuthResponse jwtAuthResponse=new JwtAuthResponse();
		jwtAuthResponse.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(jwtAuthResponse,HttpStatus.OK);
		
	}

	private void authenticate(String username, String password)  {
		
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username, password);
		try 
		{
			authenticationManager.authenticate(authenticationToken);
		
		}
		catch(DisabledException d)
		{
			d.printStackTrace();
			// d.getMessage();
		}
		
	}
}
