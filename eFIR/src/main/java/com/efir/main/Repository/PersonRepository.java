package com.efir.main.Repository;

import com.efir.main.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Query("SELECT p  FROM Person p WHERE p.firid = :Firid AND p.personType = 'VICTIM'")
    List<Person> findVictimsByComplaintId(int Firid);

    @Query("SELECT p FROM Person p WHERE p.complaint.id = :complaintId AND p.personType = 'ACCUSED'")

    List<Person> findAccusedByComplaintId(int Firid);

    @Query("SELECT p FROM Person p WHERE p.complaint.id = :complaintId AND p.personType = 'WITNESS'")

    List<Person> findWitnessesByComplaintId(int Firid);

}
