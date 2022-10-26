/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Pierini.Portafolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Pieirni Nahuel Nicolas
 */
@Entity

public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameE;
    private String dateI;
    private String dateF;
    private String descE;
    //constructor

    
    public Experience() {
    }

    
    public Experience(String nameE, String dateI, String dateF, String descE) {
        this.nameE = nameE;
        this.dateI = dateI;
        this.dateF = dateF;
        this.descE = descE;
    }
    //Getters & Setters

    
    public int getId() {
        return id;
    }

   
    public void setId(int id) {
        this.id = id;
    }

   
    public String getNameE() {
        return nameE;
    }

    
    public void setNameE(String nameE) {
        this.nameE = nameE;
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

   
    public String getDescE() {
        return descE;
    }

    
    public void setDescE(String descEd) {
        this.descE = descEd;
    }
    
}
