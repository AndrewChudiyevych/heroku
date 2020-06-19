package edu.andrew.kursach.dao.patient.interfaces;

import edu.andrew.kursach.model.Patient;

import java.util.List;

public interface IPatientDao {
    Patient save(Patient patient);
    Patient get(String id);
    List<Patient> getAll();
    Patient edit(Patient patient);
    Patient delete(String id);
}
