package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @Size(max = 500)
    private String description;
    @ManyToMany(mappedBy = "skills")
    private final List<Job> jobs = new ArrayList<>();

    //Constructor
    public Skill(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }



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