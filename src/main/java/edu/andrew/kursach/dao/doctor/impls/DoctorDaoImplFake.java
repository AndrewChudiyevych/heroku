package edu.andrew.kursach.dao.doctor.impls;

import edu.andrew.kursach.dao.doctor.interfaces.IDoctorDao;
import edu.andrew.kursach.dataSet.DataSet;
import edu.andrew.kursach.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DoctorDaoImplFake implements IDoctorDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Doctor save(Doctor doctor) {
        dataSet.getDoctors().add(doctor);
        return doctor;
    }

    @Override
    public Doctor get(String id) {
        return null;
    }

    @Override
    public List<Doctor> getAll() {
        return this.dataSet.getDoctors();
    }

    @Override
    public Doctor edit(Doctor doctor) {
        return null;
    }

    @Override
    public Doctor delete(String id) {
        return null;
    }
}
