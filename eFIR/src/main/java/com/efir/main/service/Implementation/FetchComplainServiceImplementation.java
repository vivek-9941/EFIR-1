package com.efir.main.service.Implementation;

import com.efir.main.Repository.ComplaintRepo;
import com.efir.main.Repository.PersonRepository;
import com.efir.main.Repository.UserRepository;
import com.efir.main.exeptions.ComplaintNotFoundException;
import com.efir.main.exeptions.NoComplaintsFoundExceptions;
import com.efir.main.model.Complaint;
import com.efir.main.model.Person;
import com.efir.main.model.User;
import com.efir.main.service.FetchComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchComplainServiceImplementation implements FetchComplainService {
    @Autowired
    ComplaintRepo repo;
    @Autowired
    UserRepository userrepo;
    @Autowired
    PersonRepository personrepo;
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

    public Complaint savecomplaint(Complaint complaint) {
       return  repo.save(complaint);
    }

    public User saveuser(User user) {
       return  userrepo.save(user);
    }


    public List<Person> saveperson(List<Person> person){
           return  personrepo.saveAll(person);
    }
}
