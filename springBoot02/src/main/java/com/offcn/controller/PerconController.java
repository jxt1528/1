package com.offcn.controller;

import com.offcn.pojo.Person;
import com.offcn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PerconController {

    @Autowired
    private PersonService personService;

    @PostMapping("/")
    public void addPerson(@RequestBody Person person) {
        personService.add(person);
    }

    @GetMapping("/")
    public List<Person> getAllPerson() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") Long id) {
        return personService.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        personService.delete(id);
    }

    @PutMapping("/")
    public void updatePerson(@RequestBody Person person) {
        personService.update(person);
    }

}