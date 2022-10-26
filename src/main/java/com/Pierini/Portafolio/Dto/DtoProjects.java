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
public class DtoProjects {

      @NotBlank
    private String name;
    @NotBlank
    private String descP;
    @NotBlank
    private String imgP;
    
    //constructor

    public DtoProjects() {
    }

    public DtoProjects(String name, String descP, String imgP) {
        this.name = name;
        this.descP = descP;
        this.imgP = imgP;
    }
    //getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
