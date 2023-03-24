package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Employer extends AbstractEntity {
    @NotNull
    @Size(min = 2, max = 50)
    //use static because it will only have one location?
//    private static String location;
    private String location;

//public accessor methods-commonly known as get method.


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //No arg constructor
    public Employer() {
    }
}


