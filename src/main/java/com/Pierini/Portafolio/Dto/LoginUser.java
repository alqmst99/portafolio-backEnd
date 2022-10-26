package com.Pierini.Portafolio.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Pieirni Nahuel Nicolas 
 */
public class LoginUser {
@NotBlank
private String nameUser;
@NotBlank
private String password;

   
    public String getNameUser() {
        return nameUser;
    }

    
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

}
