package com.efir.main.service;

import com.efir.main.exeptions.ComplaintNotFoundException;
import com.efir.main.model.Complaint;

import java.util.List;

public interface FetchComplainService {
    Complaint fetchByFirId(int id) throws ComplaintNotFoundException;

    List<Complaint> fetchAll();

}
