package com.mysecurity.spsecuritydemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebMvcSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("employee")
        .password("employee123")
        .roles("EMPLOYEE")
        .and()
        .withUser("admin")
        .password("admin123")
        .roles("ADMIN")
        .and()
        .withUser("manager")
        .password("manager123")
        .roles("MANAGER");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/manager").hasAnyRole("ADMIN","MANAGER")
        .antMatchers("/employee").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
        .antMatchers("/").permitAll()
        .and()
        .formLogin();
    }
}
