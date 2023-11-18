package com.google.drive.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.drive.model.User;
import com.google.drive.repository.UserRepository;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/register-user")
    public String register_user(@ModelAttribute("User") User user) {
        user.setRecordCreated(new Date().toString());
        userRepository.save(user);
        return "login";
    }

    // @PostMapping("/login")
    // public String login_user(@RequestParam("email") String email, @RequestParam("password") String password,
    //         Model model,HttpSession session) {
    //     List<User> users = userRepository.findAll();
    //     for (User user : users) {
    //         if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
    //             session.setAttribute("user", user);
    //             return "redirect:/home";
    //         }
    //     }
    //     model.addAttribute("error", "Invalid login credentials.");
    //     return "login";
    // }

    @PostMapping("/login")
    public String login_user(@RequestParam("email") String email, @RequestParam("password") String password,
        Model model,HttpSession session) {
        User user=userRepository.getUserByEmailAndPassword(email.trim(), password.trim());
        if(user!=null)
        {
            session.setAttribute("user", user);
            return "redirect:/home";
        }
        model.addAttribute("error", "Invalid login credentials.");
        return "login";
    }

    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    

    @GetMapping("/users/{start}/{end}")
    public String getUserByIds(@PathVariable("start")long start,@PathVariable("end")long end,Model model){
        List<User> users=userRepository.getUsersByIds(start, end);
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/{range}")
    public String getUsersByRange(@PathVariable("range")String range,Model model){        
        int start;
        int end;
        boolean number=true;
        for(int i=0;i<range.length();i++){
            if(Character.isDigit(range.charAt(i))==false){
                number=false;
                break;
            }
        }
        if(number==true){
            Optional<User> user=userRepository.findById(Long.parseLong(range.trim()));
            if(user.isPresent())
            model.addAttribute("user", user.get());
            return "user";
        }
        else{
            start=Integer.parseInt(range.substring(0, range.indexOf('-')));
            end=Integer.parseInt(range.substring(range.indexOf('-')+1,range.length()));
            List<User> users=userRepository.getUsersByIds(start, end);
            model.addAttribute("users", users);
            return "users";
        }
        
    }

    // @GetMapping("/users/{id}")
    // public String getUserById(@PathVariable("id")long id,Model model){
    //     Optional<User> user=userRepository.findById(id);
    //     if(user.isPresent())
    //     model.addAttribute("user", user.get());
    //     return "user";
    // }


    @GetMapping("/delete/{id}")
    public String delete_user(@PathVariable("id")long id, Model model){
        userRepository.deleteById(id);
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @GetMapping("/edit/{id}")
    public String edit_view(@PathVariable("id")long id, Model model){
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent())
        model.addAttribute("user", user.get());
        return "edit-user";
    }
}
