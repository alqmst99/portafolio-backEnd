package com.Pierini.Portafolio.Segurity.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Pieirni Nahuel Nicolas
 */
public class UsuarioPrincipal implements UserDetails {

    private String name;
    private String nameUser;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

   
    public UsuarioPrincipal() {
    }

    public UsuarioPrincipal(String name, String nameUser, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.nameUser = nameUser;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

   
    public static UsuarioPrincipal build(Usuario usuario) {
        List<GrantedAuthority> authorities = usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolName().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getName(), usuario.getNameUser(), usuario.getEmail(), usuario.getPassword(), authorities);
    }

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    
    @Override
    public String getPassword() {
        return password;
    }

    
    @Override
    public String getUsername() {
        return nameUser;
    }

   
    @Override
    public boolean isAccountNonExpired() {
        return true;

    }

    
    @Override
    public boolean isAccountNonLocked() {
        return true;

    }

    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;

    }

    
    @Override
    public boolean isEnabled() {
        return true;

    }

    public String getEmail() {
        return email;
    }

   
}
