package com.efir.main.controller;

import com.efir.main.model.Person;
import com.efir.main.service.Implementation.FetchPersonsAssociatedimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")


public class PersonRegister {

    @Autowired
    FetchPersonsAssociatedimpl fetch;

    @PostMapping("/register")
    public List<Person> RegisterPerson(@RequestBody List<Person> person) {
        System.out.println(person);
        return fetch.saveperson(person);
    }
}
