package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController{

        @Autowired
        private SkillRepository skillRepository;

        @RequestMapping("")
//        @GetMapping("")
        public String index(Model model) {
            model.addAttribute("skills",skillRepository.findAll());
            return "skills/index";
            /*
            model.addAttribute("title", "All Skills");
            model.addAttribute("columns", columnChoices);
*/
//            model.addAttribute("title", "All Skills");

//            Iterable skills  =skillRepository.findAll());


        }

        @GetMapping("add")
        public String displayAddSkillForm(Model model) {
            model.addAttribute("skill", new Skill());
            return "skills/add";
        }

        @PostMapping("add")
        public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                             Errors errors, Model model) {

            if (errors.hasErrors()) {
                return "skills/add";
            }
//        Save a valid object
            skillRepository.save(newSkill);
            return "redirect:./";
        }
    //            newSkill.setSkills(skillObj)
//            skillRepository.save(newSkill);
        @GetMapping("view/{skillId}")
        public String displayViewSkill(Model model, @PathVariable int skillId) {

            Optional optSkill = skillRepository.findById(skillId);
            if (optSkill.isPresent()) {
               Skill skill = (Skill) optSkill.get();
                model.addAttribute("skill", skill);
                return "skills/view";
            } else {
                return "redirect:../";
            }
        }
    }


