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

    private String Name;
    private String NameUser;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    /**
     *
     */
    public UsuarioPrincipal() {
    }

    public UsuarioPrincipal(String Name, String NameUser, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.Name = Name;
        this.NameUser = NameUser;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     *
     * @param usuario
     * @return
     */
    public static UsuarioPrincipal build(Usuario usuario) {
        List<GrantedAuthority> authorities = usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolName().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNameUser(), usuario.getNameUser(), usuario.getEmail(), usuario.getPassword(), authorities);
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     *
     * @return
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    @Override
    public String getUsername() {
        return NameUser;
    }

    /**
     *
     * @return
     */
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
}
