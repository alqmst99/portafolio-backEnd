/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Pierini.Portafolio.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Pieirni Nahuel Nicolas 
 *@email nahuel.pierini90@hotmail.com
 */
public class DtoPerson {
    @NotBlank
private String name;
@NotBlank
    private String lastName;
  @NotBlank
    private String descP;
   @NotBlank
    private String imgP;
//constructor

   
    public DtoPerson() {
    }

   
    public DtoPerson(String name, String lastName, String descP, String imgP) {
        this.name = name;
        this.lastName = lastName;
        this.descP = descP;
        this.imgP = imgP;
    }
 

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getLastName() {
        return lastName;
    }

    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    public String getDescP() {
        return descP;
    }

   
    public void setDescP(String descP) {
        this.descP = descP;
    }

   
    public String getImgP() {
        return imgP;
    }

   
    public void setImgP(String imgP) {
        this.imgP = imgP;
    }
    
}
