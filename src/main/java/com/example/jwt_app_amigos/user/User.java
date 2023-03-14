package com.example.jwt_app_amigos.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_user")
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {//Предоставленные полномочия
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {//Срок действия учетной записи не истек
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {//Учетная запись не заблокирована
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {//Срок действия учетных данных не истек
        return true;
    }

    @Override
    public boolean isEnabled() {//включен
        return true;
    }
}
