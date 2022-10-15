/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Pierini.Portafolio.Dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Pieirni Nahuel Nicolas 
 */
public class JwtDto {
private String token;
private  String Bearer = "Bearer";
private String nameUser;
private  Collection <? extends GrantedAuthority>authority;

    public JwtDto(String token, String nameUser, Collection<? extends GrantedAuthority> authority) {
        this.token = token;
        this.nameUser = nameUser;
        this.authority = authority;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return Bearer;
    }

    public void setBearer(String Bearer) {
        this.Bearer = Bearer;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Collection<? extends GrantedAuthority> getAuthority() {
        return authority;
    }

    public void setAuthority(Collection<? extends GrantedAuthority> authority) {
        this.authority = authority;
    }

   


}
