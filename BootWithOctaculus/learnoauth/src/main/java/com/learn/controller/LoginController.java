package com.learn.controller;

// import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// import org.springframework.core.io.ClassPathResource;
// import org.springframework.core.io.Resource;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LoginController 
{
    @GetMapping("/")
    public String index()
    {
        return "index";
    }   
    @GetMapping("/dashboard")
    public String dashboard()
    {
        return "dashboard";
    }
    // @GetMapping("/logout")
    // public String logout(HttpServletRequest request, HttpServletResponse response) {
    //     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //     if (auth != null) {
    //         new SecurityContextLogoutHandler().logout(request, response, auth);
    //     }
    //     return "redirect:/login?logout"; // Redirect to login page with a logout parameter
    // } 
    
    // @GetMapping("/images/{imageName}")
    // public ResponseEntity<Resource> renderImage(@PathVariable String imageName) throws IOException
    // {
    //     Resource imageResource = new ClassPathResource("static/images/" + imageName);
    //     return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageResource);
    // }
}
