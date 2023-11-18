// package com.learn.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @EnableWebSecurity
// public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter
// {
//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//         auth.inMemoryAuthentication()
//         .withUser("Aman")
//         .password("1234")
//         .roles("admin")
//         .and()
//         .withUser("naman")
//         .password("1234")
//         .roles("user")
//         .and()
//         .withUser("tarun")
//         .password("1234")
//         .roles("seller");
         
//     }
//     @Bean
//     public PasswordEncoder getPasswordEncoder()
//     {
//         return NoOpPasswordEncoder.getInstance();
//     }
//     @Override
//     public void configure(HttpSecurity http) throws Exception
//     {
//         // http.authorizeRequests()
//         // .antMatchers("/","static/css","static/js","static/").permitAll()
//         // .antMatchers("/**").hasRole("admin")
//         // .and()
//         // .formLogin();

//         http.authorizeRequests()
//         .antMatchers("/admin").hasRole("admin")        
//         .antMatchers("/user").hasAnyRole("user","admin")        
//         .antMatchers("/").permitAll()
//         .and()
//         .formLogin();
        
        
//     }
    
// }
