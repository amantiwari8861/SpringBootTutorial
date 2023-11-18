package com.learn.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.learn.config.security.jwt.JwtAuthenticationEntryPoint;
// import com.learn.config.security.jwt.JwtAuthenticationFilter;
import com.learn.services.UserService;

@Configuration
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    // @Autowired
    // private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    // @Autowired
    // private JwtAuthenticationFilter jwtAuthenticationFilter;

    // @Autowired
    // private UserService userService;

    private final String PUBLIC_URLS[]={"/**","/","/login","/register","/images/**","/css/**","/js/**","/assets/**/**","/html/**"}; 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    //     // http
    //     // .authorizeRequests()
    //     // .anyRequest()
    //     // .authenticated()
    //     // .and()
    //     // .oauth2Login();

    //     // http
    //     // .authorizeRequests()
    //     // .anyRequest()
    //     // .authenticated()
    //     // .and()
    //     // .formLogin()
    //     // .loginPage("/login")
    //     // .permitAll();
        
        http.csrf().disable();
        
        http
        .authorizeHttpRequests()
        .antMatchers(PUBLIC_URLS).permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/user")
            .and()
        .oauth2Login()
            .loginPage("/login")
            .defaultSuccessUrl("/user")
            .and()
        .logout()  // Add the logout configuration
            .logoutUrl("/logout")  // Specify the URL for logout
            .logoutSuccessUrl("/login")  // Specify the URL to redirect after successful logout
            .invalidateHttpSession(true)  // Invalidate session
            .deleteCookies("JSESSIONID");  // Delete cookies (if needed)
            // .and()
            // .exceptionHandling()
            // .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
        // .and()
        //     .exceptionHandling()
            // .authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
		// .and()
        //     .sessionManagement()
        //     .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// http.addFilterBefore(this.jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
	
    } 

	// @Bean
	//  PasswordEncoder passwordEncoderNew()
	// {
	// 	return new BCryptPasswordEncoder();
	// }
    //	@Bean
    //	public static NoOpPasswordEncoder passwordEncoder()
    //	{
    //		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    //	}
	// @Bean
	// @Override
	// public AuthenticationManager authenticationManagerBean() throws Exception {
	// 	return super.authenticationManagerBean();
	// }
    // @Override
	// protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	// auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN");
	
	// auth.userDetailsService(userService).passwordEncoder(passwordEncoderNew());
	// }
    // @Bean
    // @Override
    // public UserDetailsService userDetailsService() {
    //     UserDetails user = User.withDefaultPasswordEncoder()
    //         .username("krish")
    //         .password("1234")
    //         .roles("user")
    //         .build();

    //     return new InMemoryUserDetailsManager(user);
    // }
}
