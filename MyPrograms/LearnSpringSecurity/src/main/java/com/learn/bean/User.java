// package com.learn.bean;

// import java.util.Arrays;
// import java.util.Collection;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// public class User implements UserDetails {
//     private String userName;

//     // private
//     public User(String userName) {
//         this.userName = userName;
//     }

//     public User() {
//     }

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         return Arrays.asList(new SimpleGrantedAuthority("ROLE_user"));
//     }

//     @Override
//     public String getPassword() {
//         return "1234";
//     }

//     @Override
//     public String getUsername() {
//         return userName;
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         return true;
//     }
// }
