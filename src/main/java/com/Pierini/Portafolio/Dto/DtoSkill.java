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
private int percent;
//constructors

    public DtoSkill() {
    }

    public DtoSkill(String name, int percent) {
        this.name = name;
        this.percent = percent;
    }
//Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
    
}
