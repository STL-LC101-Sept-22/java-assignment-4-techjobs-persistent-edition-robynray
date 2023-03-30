package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
//import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    //Spring Boot will populate the employerRepository field.
    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

//    @RequestMapping("")
    @RequestMapping("")
    public String index(Model model) {

//        model.addAttribute("title", "All Employers");
        model.addAttribute("employers", employerRepository.findAll());
        //Take out: M
//        model.addAttribute("employer", "All Employers");
//        Iterable employers = employerRepository.findAll();
//        model.addAttribute("title", "Add Employer");
        return "employers/index";
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

//    public EmployerRepository getEmployerRepository() {
//        return employerRepository;
//    }
//
//    public void setEmployerRepository(EmployerRepository employerRepository) {
//        this.employerRepository = employerRepository;
//    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()){
            model.addAttribute(newEmployer);
            return  "employers/add";
        }
//        Save a valid object
        employerRepository.save(newEmployer);
        return "redirect:";
    }
//        Employer employer = newEmployer;
//    Object employer=employerRepository.save(newEmployer);

//        model.addAttribute(employerRepository.save(newEmployer));
//       employerRepository.save(newEmployer);


    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }
}
