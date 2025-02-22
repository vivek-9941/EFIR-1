package com.efir.main.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private String occupation;
    private int age;
    private long aadhar;
    private int contact;
    private int firid;
    @Enumerated(EnumType.STRING)
    private PersonType personType;  // VICTIM, ACCUSED, or WITNESS

    @ManyToOne
    @JoinColumn(name = "complaint_id")  // Links to the FIR
    private Complaint complaint;
}
