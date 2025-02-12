package com.efir.main.model;

import com.efir.main.model.complaintdata.ComplaintStatus;
import com.efir.main.model.complaintdata.IncidentDetails;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "complaint")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ElementCollection
    private List<Person> victims;

    @Column(nullable = false)
    private  int firid;

    @ElementCollection
    private List<Person> accusedId;

    @ElementCollection
    private List<Person> witnessId;

    @ManyToOne
    @JoinColumn(name = "filed_by")
    private User filedBy;
    //One user can file multiple complaints

    @Embedded
    private ComplaintStatus complaintStatus  = new ComplaintStatus();

    @Embedded
    private IncidentDetails incidentDetails;

    @ElementCollection
    private   List<String> evidence;
    //in dirve link fromat
}
