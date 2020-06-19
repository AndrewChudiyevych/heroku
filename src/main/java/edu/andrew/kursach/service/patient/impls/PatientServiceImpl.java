package edu.andrew.kursach.service.patient.impls;

import edu.andrew.kursach.dao.patient.impls.PatientDaoImplFake;
import edu.andrew.kursach.model.Patient;
import edu.andrew.kursach.service.patient.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService {
    @Autowired
    PatientDaoImplFake dao;

    @PostConstruct
    void init() {
        List<Patient> list = dao.getAll();
        //repository.saveAll(list);
    }


    @Override
    public Patient save(Patient patient) {
        return dao.save(patient);
    }

    @Override
    public Patient get(String id) {
        return dao.getAll().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Patient> getAll() {
        return dao.getAll();
    }

    @Override
    public Patient edit(Patient patient) {
        return null;
    }

    @Override
    public Patient delete(String id) {
        Patient patient = this.get(id);
        dao.getAll().remove(patient);
        return patient;
    }
}
