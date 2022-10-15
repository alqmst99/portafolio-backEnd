/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Pierini.Portafolio.Segurity.Entity;

/**
 *
 * @author Pieirni Nahuel Nicolas 
 */
import com.Pierini.Portafolio.Segurity.enums.RolName;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Pieirni Nahuel Nicolas 
 */
@Entity
public class Rol {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@NotNull
@Enumerated(EnumType.STRING)
private RolName rolName;

    
    public Rol() {
    }

    public Rol(RolName rolName) {
        this.rolName = rolName;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    public RolName getRolName() {
        return rolName;
    }

    public void setRolName(RolName rolName) {
        this.rolName = rolName;
    }

}
