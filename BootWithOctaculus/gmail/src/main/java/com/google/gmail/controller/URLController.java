package com.google.gmail.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Controller
public class URLController {
    
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

    @GetMapping("/send-mail")
    public String send_mail(){
        return "send-mail";
    }

    @PostMapping("/sendMail")
    public String sendMail(@RequestParam("to")String to,@RequestParam("subject")String subject,Model model){
        final String senderEmail = username; 
        final String senderPassword = password;
        final String recipientEmail = to.trim();

        //generate 6 digit OTP
        Random random = new Random();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            otp.append(random.nextInt(10));
        }

        // SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", smtp_auth);
        properties.put("mail.smtp.starttls.enable", starttls_enable);
        properties.put("mail.smtp.host", host); 
        properties.put("mail.smtp.port", port); 

        // Create a Session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a MimeMessage object
            Message msg = new MimeMessage(session);

            // Set the sender and recipient addresses
            msg.setFrom(new InternetAddress(senderEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            // Set the subject and content
            msg.setSubject(subject);
            msg.setText("OPT to verify your account is "+otp+". This OTP is only valid for 10 mins.");

            // Send the message
            Transport.send(msg);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email.");
        }

        return "success";
    }
}
