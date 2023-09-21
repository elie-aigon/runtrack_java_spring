package com.example.jour3.controller;

import com.example.jour3.dao.PersonRepository;
import com.example.jour3.model.Person;
import com.example.jour3.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PersonController {
    @Autowired
    private PersonService PersonService;

    @PostMapping("deletePerson")
    public String deletePerson(@RequestParam int id, Model model){
        PersonService.deleteById(id);
        sendMessage(model, "confirmMessage", "Person n°" + id + " deleted");
        reloadTable(model);
        return "view";
    }

    @PostMapping("/modifyPerson")
    public String modifyPerson(@RequestParam String name, @RequestParam int age, @RequestParam int id, Model model){
        String message = PersonService.modifyById(id, name, age);
        reloadTable(model);
        sendMessage(model, "confirmMessage", message);
        return "view";
    }

    @PostMapping("/savePerson")
    public String savePerson(@RequestParam String name, @RequestParam int age, Model model) {
        Person person = new Person();
        person.setAge(age);
        person.setName(name);
        PersonService.save(person);
        reloadTable(model);
        sendMessage(model, "confirmMessage", name +" " + age + " has been added to database");
        return "view";
    }

    @GetMapping("/")
    public String initPerson(){
        return "view";
    }

    public void reloadTable(Model model) {
        List<Person> personList = PersonService.getAll();
        model.addAttribute("personnes", personList);

    }

    public void sendMessage(Model model, String nameContainer,String message){
        model.addAttribute(nameContainer, message);
    }
}
