package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {
    @NotNull
    @Size(min = 2, max = 50)
    private String location;

    @OneToMany
    @JoinColumn(name = "employer_id")
    private List<Job> jobs =new ArrayList<>();

//  Constructor
    public Employer(String location) {
        this.location = location;
    }

    public Employer(String location, List<Job> jobs) {
        this.location = location;
        this.jobs = jobs;
    }
//public accessor methods-commonly known as get method.

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    //No arg constructor
    public Employer() {
    }

}


