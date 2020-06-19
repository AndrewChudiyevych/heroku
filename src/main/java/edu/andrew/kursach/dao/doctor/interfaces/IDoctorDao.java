package edu.andrew.kursach.dao.doctor.interfaces;


import edu.andrew.kursach.model.Doctor;

import java.util.List;

public interface IDoctorDao {
    Doctor save(Doctor doctor);
    Doctor get(String id);
    List<Doctor> getAll();
    Doctor edit(Doctor doctor);
    Doctor delete(String id);
}
