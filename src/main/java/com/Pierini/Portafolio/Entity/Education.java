package com.Pierini.Portafolio.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Pieirni Nahuel Nicolas
 * @email nahuel.pierini90@hotmail.com
 */
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameE;
    private String dateI;
    private String dateF;
    private String descEd;
//Constructors

  
    public Education() {
    }

    
    public Education(String nameE, String dateI, String dateF, String descEd) {
        this.nameE = nameE;
        this.dateI = dateI;
        this.dateF = dateF;
        this.descEd = descEd;
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

   
    public String getDescEd() {
        return descEd;
    }

    
    public void setDescEd(String descEd) {
        this.descEd = descEd;
    }

}
