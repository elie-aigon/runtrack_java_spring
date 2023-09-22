package com.example.jour5.controller;

import com.example.jour5.model.Person;
import com.example.jour5.service.PersonService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PersonController {
    @Autowired
    private PersonService PersonService;

    public void init() {
        PersonService.save(new Person("Yoann", 20));
        PersonService.save(new Person("Clément", 20));
        PersonService.save(new Person("Next GOSUazerazerazerazer", 21));
        PersonService.save(new Person("Elie", 20));
    }


    @GetMapping("/displayPersons")
    public String initPerson(Model model){
        init();
        loadtable(model);
        return "displayPersons";
    }
    @GetMapping("/addPersonForm")
    public String addPersonForm(Model model){
        model.addAttribute("Person", new Person());
        return "addPersonForm";
    }
    @PostMapping("/addPerson")
    public String addPerson(Model model, @ModelAttribute ("Person") @Valid Person person, BindingResult result){
        if (result.hasErrors()){
            return "addPersonForm";
        }
        PersonService.save(person);
        sendMessage(model, "confirmMessage", "New Person has been hadded.");
        return "redirect:/displayPersons";
    }


/* Basics Generics methods*/
    public void loadtable(Model model) {
        List<Person> personList = PersonService.getAll();
        model.addAttribute("persons", personList);
    }

    public void sendMessage(Model model, String nameContainer,String message){
        model.addAttribute(nameContainer, message);
    }
}
