package com.example.jour3.service;

import com.example.jour3.dao.PersonRepository;
import com.example.jour3.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository PersonRepo;

    public List<Person> getAll() {
        return PersonRepo.findAll();
    }

    public Person getById(int id) {
        return PersonRepo.findById(id).orElse(null);
    }

    public void save(Person person) {
        PersonRepo.save(person);
    }
    public String modifyById(int id, String name, int age){
        Optional<Person> optional = PersonRepo.findById(id);
        if(optional.isPresent()){
            Person current = optional.get();
            current.setName(name);
            current.setAge(age);
            return "Modified successfuly Person n°" + id;
        } else{
            return "Couldnt find Person n°" + id;
        }
    }
    public void deleteById(int id) {
        PersonRepo.deleteById(id);
    }

}
