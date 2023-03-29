package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {
//    Removed for Test 3 because it now extends Abstract Entity
//
//    @Id--- This a primary key
//    @GeneratedValue-----The database will generate a primary key

    //    private int id;
//    private String name;
//    private String employer;
//    private String skills;
    @ManyToOne
    private Employer employer;
    //This was orginally  wrong OnetoMany  @Test
//    public void testJobSkillsHasCorrectTypeAndAnnotation ()
    @ManyToMany
    @JoinColumn(name = "job.skills")
    private List<Skill> skills = new ArrayList<>();

    public Job() {
    }


//Constructor

    public Job(Employer anEmployer, List<Skill> someSkills) {
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    // Getters and setters.


    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}


    //    public void setSkills(String skills) {
//        this.skills = skills;
//    }


//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    public String getEmployer() {
//        return employer;


//    public void setEmployer(String employer) {
//        this.employer = employer;
//    }
//
//    public String getSkills() {
//        return skills;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }
//}
