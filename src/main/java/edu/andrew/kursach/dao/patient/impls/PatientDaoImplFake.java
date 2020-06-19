package edu.andrew.kursach.dao.patient.impls;

import edu.andrew.kursach.dao.patient.interfaces.IPatientDao;
import edu.andrew.kursach.dataSet.DataSet;
import edu.andrew.kursach.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientDaoImplFake implements IPatientDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Patient save(Patient patient) {
        dataSet.getPatients().add(patient);
        return patient;
    }

    @Override
    public Patient get(String id) {
        return null;
    }

    @Override
    public List<Patient> getAll() {
        return this.dataSet.getPatients();
    }

    @Override
    public Patient edit(Patient patient) {
        return null;
    }

    @Override
    public Patient delete(String id) {
        return null;
    }
}
