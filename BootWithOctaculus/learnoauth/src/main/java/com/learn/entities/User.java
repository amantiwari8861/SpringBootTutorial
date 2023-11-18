package com.learn.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username", nullable = false, length = 30)
    private String username;
    private String email;
    private String password;
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialNonExpired = true;
    private boolean isUserNonEnabled = true;
    private String roles;
    // @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    // @JoinTable(
    // name = "user_role",
    // joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
    // inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName =
    // "id")
    // )
    // private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // List<GrantedAuthority> authorities=roles.stream()
        // .map(r->new SimpleGrantedAuthority(r.getRoleName()))
        // .collect(Collectors.toList());

        List<GrantedAuthority> authorities = Arrays.asList(roles.split(",")).stream()
                .map(r -> new SimpleGrantedAuthority(r))
                .collect(Collectors.toList());

        return authorities;
    }
    // public Set<Role> getRoles() {
    // return roles;
    // }

    // public void setRoles(Set<Role> roles) {
    // this.roles = roles;
    // }
    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isUserNonEnabled;
    }

}
