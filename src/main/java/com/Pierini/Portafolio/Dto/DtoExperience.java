package com.Pierini.Portafolio.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Pieirni Nahuel Nicolas 
*@email nahuel.pierini90@hotmail.com
 */
public class DtoExperience {
    @NotBlank
    private String nameE;
    @NotBlank
    private String descE;
    @NotBlank
    private String dateI;
    @NotBlank
    private String dateF;
    //constructors

    public DtoExperience() {
    }

    public DtoExperience(String nameE, String descE, String dateI, String dateF) {
        this.nameE = nameE;
        this.descE = descE;
        this.dateI = dateI;
        this.dateF = dateF;
    }

    //Getters & Setters
    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public String getDescE() {
        return descE;
    }

    public void setDescE(String descE) {
        this.descE = descE;
    }

    public String getDateI() {
        return dateI;
    }

    public void setDateI(String dateI) {
        this.dateI = dateI;
    }

    public String getDateF() {
        return dateF;
    }

    public void setDateF(String dateF) {
        this.dateF = dateF;
    }
    

}
