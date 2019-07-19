package com.example.petproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    PetRepository petRepository;

    @RequestMapping("/")
    public String homepage(Model model) {
        model.addAttribute("pets", petRepository.findAll());
        return "homepage";
    }

    @RequestMapping("/petlist")
    public String listPets(Model model) {
        model.addAttribute("pets", petRepository.findAll());
        return "petlist";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("pets", petRepository.findAll());
        return "Login";
    }

    @GetMapping("/add")
    public String form(Model model){
        model.addAttribute("pet", new Pet());
        return "petform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Pet pet, BindingResult result){
        if (result.hasErrors()){
            return "petform";
        }
        petRepository.save(pet);
        return "redirect:/";

    }

    @RequestMapping("/update/{id}")
    public String updateResume(@PathVariable("id") long id, Model model) {
        model.addAttribute("pet", petRepository.findById(id).get());
        return "petform";
    }

    @RequestMapping("/delete/{id}")
    public String delResume(@PathVariable("id") long id){
        petRepository.deleteById(id);
        return "redirect:/";
    }
}