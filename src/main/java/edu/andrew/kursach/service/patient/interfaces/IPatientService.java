package edu.andrew.kursach.service.patient.interfaces;

import edu.andrew.kursach.model.Patient;

import java.util.List;

public interface IPatientService {
    Patient save(Patient patient);
    Patient get(String id);
    List<Patient> getAll();
    Patient edit(Patient patient);
    Patient delete(String id);
}
