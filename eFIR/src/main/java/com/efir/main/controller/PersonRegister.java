package com.efir.main.controller;

import com.efir.main.model.Person;
import com.efir.main.service.Implementation.FetchComplainServiceImplementation;
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
    FetchComplainServiceImplementation fetchp;
@PostMapping("/register")
        public List<Person> RegisterPerson( @RequestBody  List<Person> person){
          return  fetchp.saveperson(person);
        }
}
