package com.learn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OnlineBankingBackend31Application implements CommandLineRunner
//public class OnlineBankingBackend31Application
{	
	public static void main(String[] args) 
	{
		SpringApplication.run(OnlineBankingBackend31Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hii "+passwordEncoderNew().encode("1234"));
	}
//	@Bean
	public PasswordEncoder passwordEncoderNew()
	{
		return new BCryptPasswordEncoder();
	}
}
