
package com.Pierini.Portafolio.Dto;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Pieirni Nahuel Nicolas
 */
public class NewUser {

    private String name;
    private String nameUser;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();

    
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    
}
