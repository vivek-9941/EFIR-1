package com.efir.main.model;

import com.efir.main.model.complaintdata.ComplaintStatus;
import com.efir.main.model.complaintdata.IncidentDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "complaint")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "filedBy")
@Builder
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

////    @OneToMany(mappedBy = "complaint", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Person> victims;
//
////    @OneToMany(mappedBy = "complaint", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Person> accused;
//
////    @OneToMany(mappedBy = "complaint", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Person> witnesses;
    //not keeping persons in complaint on fetching all the persons must be fetched associated with complaint  along with complaint manually
    //the only thing is both should have the same firid

    @Column(nullable = false)
    private int firId;

    @ElementCollection
    @Column(nullable = false)
    private List<String> ipc;



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "filed_by")
    private User filedBy;

    @Embedded
    private ComplaintStatus complaintStatus = new ComplaintStatus();

    @Embedded
    private IncidentDetails incidentDetails;

    @ElementCollection
    private List<String> evidence;
}
