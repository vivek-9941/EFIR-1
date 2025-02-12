package com.efir.main.service.Implementation;

import com.efir.main.Repository.ComplaintRepo;
import com.efir.main.exeptions.ComplaintNotFoundException;
import com.efir.main.exeptions.NoComplaintsFoundExceptions;
import com.efir.main.model.Complaint;
import com.efir.main.service.FetchComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchComplainServiceImplementation implements FetchComplainService {
    @Autowired
    ComplaintRepo repo;

    @Override
    public Complaint fetchByFirId(int id) throws ComplaintNotFoundException {
        Complaint fetchedcomplaint = repo.findByfirid(id);
        if (fetchedcomplaint == null) {
            throw new ComplaintNotFoundException("No such Complaint exist!! ");
        } else {
            return fetchedcomplaint;
        }
    }

    @Override
    public List<Complaint> fetchAll() {
        List<Complaint> AllComplaints = repo.findAll();
        if (AllComplaints.isEmpty()) {
            throw new NoComplaintsFoundExceptions("NO Complaints in DataBase");
        } else {
            return AllComplaints;
        }
    }
}
