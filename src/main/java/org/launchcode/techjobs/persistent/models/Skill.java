package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    @Size(max = 500)
    private String description;



    //public accessor methods-commonly known as get method.
    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    //No arg constructor
    public Skill() {}

}