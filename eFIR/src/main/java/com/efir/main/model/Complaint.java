package com.efir.main.model;

import com.efir.main.model.complaintdata.ComplaintStatus;
import com.efir.main.model.complaintdata.IncidentDetails;
import jakarta.persistence.*;
import lombok.*;

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
    private int id;

    @OneToMany(mappedBy = "complaint", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Person> victims;

    @OneToMany(mappedBy = "complaint", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Person> accused;

    @OneToMany(mappedBy = "complaint", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Person> witnesses;

    @Column(nullable = false)
    private int firid;

    @ElementCollection
    @Column(nullable = false)
    private List<String> ipc;

    @ManyToOne
    @JoinColumn(name = "filed_by")
    private User filedBy;

    @Embedded
    private ComplaintStatus complaintStatus = new ComplaintStatus();

    @Embedded
    private IncidentDetails incidentDetails;

    @ElementCollection
    private List<String> evidence;
}
