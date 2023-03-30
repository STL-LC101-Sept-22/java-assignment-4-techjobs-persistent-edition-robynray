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
    private List<Job> jobs = new ArrayList<>();


public Skill(){


}
    public List<Job> getJobs() {
        return jobs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}


    //Constructor
//    public Skill(String description) {
//        this.description = description;
//    }

    //public accessor methods-commonly known as get method.
//    public String getDescription(){
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    public void addJobs(Job job){
//        this.jobs.add(job);
//    }
//    public List<Job> getJobs() {
//        return jobs;
//    }
//
//}