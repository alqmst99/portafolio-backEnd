package com.Pierini.Portafolio.Segurity.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Pieirni Nahuel Nicolas
 */

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String name;

    @NotNull
    @Column(unique = true)
    private String nameUser;
    
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;
    
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Rol> roles = new HashSet<>();

   
    public Usuario() {
    }

   
    public Usuario(@NotNull String name, @NotNull String nameUser, @NotNull String email,  String password) {
        this.name = name;
        this.nameUser = nameUser;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

   
    public void setId(int id) {
        this.id = id;
    }

  
    public String getName() {
        return name;
    }

  
    public void setName(String name) {
        this.name = name;
    }

    public String getNameUser() {
        return nameUser;
    }

  
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Rol> getRoles() {
        return roles;
    }


    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

}
