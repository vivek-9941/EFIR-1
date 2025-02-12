package com.efir.main.model.complaintdata;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class IncidentDetails {
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeDateOfIncident;
    private String landmark;
    private String district;
    private String subDistrict;
    private String incidentDescription;
}


