package com.Pierini.Portafolio.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Pieirni Nahuel Nicolas 
 *@email nahuel.pierini90@hotmail.com
 */
public class DtoSkill {
@NotBlank
private String name;
@NotBlank
private int porcent;
//constructors

    
    public DtoSkill() {
    }

    
    public DtoSkill(String name, int porcent) {
        this.name = name;
        this.porcent = porcent;
    }
//Getters & Setters

   
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public int getPorcent() {
        return porcent;
    }

    
    public void setPorcent(int porcent) {
        this.porcent = porcent;
    }
    
}
