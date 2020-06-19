package edu.andrew.kursach.service.doctor.impls;

import edu.andrew.kursach.dao.doctor.impls.DoctorDaoImplFake;
import edu.andrew.kursach.model.Doctor;
import edu.andrew.kursach.service.doctor.interfaces.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService {
    @Autowired
    DoctorDaoImplFake dao;

    @PostConstruct
    void init() {
        List<Doctor> list = dao.getAll();
        //repository.saveAll(list);
    }

    @Override
    public Doctor save(Doctor doctor) {
        return null;
    }

    @Override
    public Doctor get(String id) {
        return dao.getAll().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Doctor> getAll() {
        return dao.getAll();
    }



    @Override
    public Doctor edit(Doctor doctor) {
        return null;
    }

    @Override
    public Doctor delete(String id) {
        Doctor doctor = this.get(id);
        dao.getAll().remove(doctor);
        return doctor;
    }
}
