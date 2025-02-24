package com.efir.main.controller;

import com.efir.main.model.Complaint;
import com.efir.main.service.Implementation.FetchComplainServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    @Autowired
    private FetchComplainServiceImplementation registerer;

    @PostMapping("/complaint")
    public ResponseEntity<?> registerComplaint(@RequestBody Complaint complaint) {
        try {
            System.out.println(complaint);
            Complaint registered = registerer.saveComplaint(complaint);
            System.out.println(registered);
            return ResponseEntity.ok().body(registered);
        } catch (Exception e) {
            System.out.println("Problem in saving the complant");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }

    }
}
