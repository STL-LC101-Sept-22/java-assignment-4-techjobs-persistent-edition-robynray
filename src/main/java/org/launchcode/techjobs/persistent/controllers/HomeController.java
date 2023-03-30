package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private JobRepository jobRepository;


//    public HomeController(EmployerRepository employerRepository) {
//        this.employerRepository = employerRepository;
//    }

    @RequestMapping("")
    public String index(Model model) {
//        model.addAttribute("title", "My Jobs");
        //Shows a list of Tech Jobs on website
        model.addAttribute("jobs", jobRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
//        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());

//        List Employers = (List<Employer>) employerRepository.findAll();
        model.addAttribute("employers", employerRepository.findAll());

////        List Skills = (List<Skill>) skillRepository.findAll();
        model.addAttribute("skills", skillRepository.findAll());


        return "add";

    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {

     if (errors.hasErrors()) {
         return "add";}

        Employer employer = employerRepository.findById(employerId).orElse(new Employer());
        newJob.setEmployer(employer);

        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
        newJob.setSkills(skillObjs);

        jobRepository.save(newJob);
        return "redirect:";
    }

//        Optional<Employer> optEmployer = employerRepository.findById(employerId);
//        if(optEmployer.isPresent()){
//            Employer employer = optEmployer.get();
//            newJob.setEmployer(employer);
//        }
//        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
//        newJob.setSkills(skillObjs);
//
////      jobRepository.save(newJob);
//
//        return  "redirect:./";
//     }



//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Job");
//            model.addAttribute("employers", employerRepository.findAll());
//            model.addAttribute("skills", skillRepository.findAll());
//            model.addAttribute("job", newJob);
//            jobRepository.save(newJob);
//            return "add";
//        }
//        if (employerId >= 0) {
//            //Note: W suggestion
//            Optional<Employer> newEmployer = employerRepository.findById(employerId);
//           newEmployer.get();
//            newJob.setEmployer(employerRepository.findById(employerId).get());
//
////         Note: M suggestion
////        Employer employer = employerRepository.findById(employerId).orElse(new Employer());
////        newJob.setEmployer(employer);
//        }
//            List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
//            newJob.setSkills(skillObjs);
//        }
//
//        model.addAttribute("job", newJob);
//
//        return "redirect:";
//
//    }


    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        Optional optJob = jobRepository.findById(jobId);
        if (optJob.isPresent()) {
            Job job = (Job) optJob.get();
            model.addAttribute("job", job);
            return "view";

        } else {
            return "redirect:../";

        }

    }

}
