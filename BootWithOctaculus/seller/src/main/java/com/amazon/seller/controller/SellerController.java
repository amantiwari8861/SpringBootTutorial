package com.amazon.seller.controller;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amazon.seller.model.Seller;
import com.amazon.seller.service.SellerService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Controller
public class SellerController {
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private String port;
    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String smtp_auth;
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String starttls_enable;

    @Autowired
    SellerService sellerService;
    
    @RequestMapping(value = "/validate-signup",method = RequestMethod.POST)
    public String validate_signup(@ModelAttribute("Seller")Seller seller,@RequestParam("rpassword")String rpassword,HttpSession session,Model model){
        if(seller.getPassword().equals(rpassword)){
            if(sellerService.getSellerByEmailOrMobile(seller.getEmail(), seller.getMobile())==null){
                seller.setRecordCreated(new Date().toString());
                session.setAttribute("seller", seller);

                //generate 6 digit OTP
                Random random = new Random();
                StringBuilder otp = new StringBuilder();

                for (int i = 0; i < 6; i++) {
                    otp.append(random.nextInt(10));
                }

                final String senderEmail = username; 
                final String senderPassword = password;
                final String recipientEmail = seller.getEmail().trim();

                // SMTP server properties
                Properties properties = new Properties();
                properties.put("mail.smtp.auth", smtp_auth);
                properties.put("mail.smtp.starttls.enable", starttls_enable);
                properties.put("mail.smtp.host", host); 
                properties.put("mail.smtp.port", port); 

                // Create a Session with authentication
                Session s = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, senderPassword);
                    }
                });

                try {
                    // Create a MimeMessage object
                    Message msg = new MimeMessage(s);
        
                    // Set the sender and recipient addresses
                    msg.setFrom(new InternetAddress(senderEmail));
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        
                    // Set the subject and content
                    msg.setSubject("Verify your Email on Amazon");
                    msg.setText("OPT to verify your email is "+otp+". This OTP is only valid for 10 mins.");
                    
        
                    // Send the message
                    Transport.send(msg);

                    session.setAttribute("otp", otp);
        
                } catch (MessagingException e) {
                    e.printStackTrace();
                    System.out.println("Failed to send email.");
                }


                return "verify-otp";
            }
            if(sellerService.getSellerByEmailAndMobile(seller.getEmail(), seller.getMobile())!=null)
            model.addAttribute("error", "Email and Mobile already exists!.");
            else if(sellerService.getSellerByEmail(seller.getEmail())!=null)
            model.addAttribute("error", "Email already exists!.");
            else if(sellerService.getSellerByMobile(seller.getMobile())!=null)
            model.addAttribute("error", "Mobile already exists!.");
            return "signup";
        }
        model.addAttribute("error", "Password and re-type password didn't match!");
        return "signup";
    }

    @PostMapping("/verifyOTP")
    public String verifyOTP(@RequestParam("otp")String otp,Model model,HttpSession session){
        if(otp.equals(session.getAttribute("otp").toString())){
            sellerService.createSeller((Seller)session.getAttribute("seller"));
            return "home";
        }
        model.addAttribute("error", "OTP didn't match!");
        return "verify-otp";
    }


    @RequestMapping(value = "/LoginAuth", method = RequestMethod.POST)
    public String loginAuth(@RequestParam("username")String username,@RequestParam("password")String password,Model model,HttpSession session){
        if(sellerService.getSellerByEmailOrMobileAndPassword(username, password)!=null){
            session.setAttribute("seller", sellerService.getSellerByEmailOrMobileAndPassword(username, password));
            return "home";
        }
        model.addAttribute("error", "Invalid Login credentials!");
        return "signin";
    }

    @GetMapping("/change-password")
    public String change_password_view(){
        return "change-password";
    }

    @PostMapping("/ChangePassword")
    public String change_password(@RequestParam("password")String password,@RequestParam("rpassword")String rpassword,Model model,HttpSession session){
        if(password.equals(rpassword)){
            Seller seller=(Seller)session.getAttribute("seller");
            sellerService.changePassword(password, seller.getId());
            model.addAttribute("success", "Password changed successfully!");
            return "home";
        }
        model.addAttribute("error", "Password and re-type password didn't match!");
        return "change-password";
    }

    @GetMapping("/forgot-password")
    public String forgot_password_view(){
        return "forgot-password";
    }

    @PostMapping("/verifyEmail")
    public String verifyEmail(@RequestParam("email")String email,Model model,HttpSession session){
        if(sellerService.getSellerByEmail(email)!=null){
            session.setAttribute("seller", sellerService.getSellerByEmail(email));
            //generate 6 digit OTP
                Random random = new Random();
                StringBuilder otp = new StringBuilder();

                for (int i = 0; i < 6; i++) {
                    otp.append(random.nextInt(10));
                }

                final String senderEmail = username; 
                final String senderPassword = password;
                final String recipientEmail = email.trim();

                // SMTP server properties
                Properties properties = new Properties();
                properties.put("mail.smtp.auth", smtp_auth);
                properties.put("mail.smtp.starttls.enable", starttls_enable);
                properties.put("mail.smtp.host", host); 
                properties.put("mail.smtp.port", port); 

                // Create a Session with authentication
                Session s = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, senderPassword);
                    }
                });

                try {
                    // Create a MimeMessage object
                    Message msg = new MimeMessage(s);
        
                    // Set the sender and recipient addresses
                    msg.setFrom(new InternetAddress(senderEmail));
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        
                    // Set the subject and content
                    msg.setSubject("OTP to recover your account on Amazon");
                    msg.setText("OPT to recover your account is "+otp+". This OTP is only valid for 10 mins.");
                    
        
                    // Send the message
                    Transport.send(msg);

                    session.setAttribute("otp", otp);
        
                } catch (MessagingException e) {
                    e.printStackTrace();
                    System.out.println("Failed to send email.");
                }

                return "verify-account";
        }
        model.addAttribute("error", "email doesn't exist!");
        return "forgot-password";
    }

    @PostMapping("/verifyAccount")
    public String verifyAccount(@RequestParam("otp")String otp,Model model,HttpSession session){
        if(otp.equals(session.getAttribute("otp").toString())){            
            return "change-password";
        }
        model.addAttribute("error", "OTP didn't match!");
        return "verify-otp";
    }
}
