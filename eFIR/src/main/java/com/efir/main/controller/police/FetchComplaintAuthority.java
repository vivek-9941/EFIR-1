package com.efir.main.controller.police;


import com.efir.main.exeptions.NoComplaintsFoundExceptions;
import com.efir.main.model.Complaint;
import com.efir.main.service.Implementation.FetchComplainServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authority")
public class FetchComplaintAuthority {
    @Autowired
    private FetchComplainServiceImplementation fetch;

    public ResponseEntity<List<Complaint>> getAllComplaints()  {
        List<Complaint> complaints = fetch.fetchAll();
        return ResponseEntity.ok(complaints);
    }
}
