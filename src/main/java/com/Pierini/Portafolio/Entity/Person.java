package com.Pierini.Portafolio.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


 /**
 *
 * @author Nahuel Pierini
 */

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @NotNull
    
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private String descP;
    @NotNull
    private String imgP;

    public Person() {
    }

    public Person(String name, String lastName, String descP, String imgP) {
        this.name = name;
        this.lastName = lastName;
        this.descP = descP;
        this.imgP = imgP;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
