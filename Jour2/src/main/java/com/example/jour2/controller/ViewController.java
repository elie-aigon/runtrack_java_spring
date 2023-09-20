package com.example.jour2.controller;

import com.example.jour2.model.Student;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewController {
    @GetMapping("/blyat")
    public String getBlyat() {
        return "view";
    }

    @GetMapping("/form")
    public String form() {
        return "view";
    }
    @PostMapping("/traitement-form")
    public String traiterForm(@RequestParam String nom, @RequestParam String prenom, Model model) {
        String messageBienvenue = "Bienvenue, " + prenom + " " + nom + "!";

        model.addAttribute("messageBienvenue", messageBienvenue);

        return "view";
    }

    @GetMapping("/maPage")
    public String maPage(Model model) {
        List<Student> listeObjets =List.of(new Student("Elie", 20, "CHALL"), new Student("Clément", 20, "PISSLOW"));
        model.addAttribute("objets", listeObjets);
        return "view";
    }
}
