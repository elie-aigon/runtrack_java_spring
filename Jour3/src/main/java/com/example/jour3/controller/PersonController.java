package com.example.jour3.controller;

import com.example.jour3.dao.PersonRepository;
import com.example.jour3.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository repo;

    @PostMapping("/savePerson")
    public String savePerson(@RequestBody Person person) {
        repo.save(person);
        return "Person saved ...";
    }
    @GetMapping("/getAll")
    public String getAll() {
        return repo.findAll();
    }

}
