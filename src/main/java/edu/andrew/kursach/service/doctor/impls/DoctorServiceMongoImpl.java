package edu.andrew.kursach.service.doctor.impls;

import edu.andrew.kursach.dao.repository.DoctorRepository;
import edu.andrew.kursach.model.Doctor;
import edu.andrew.kursach.service.doctor.interfaces.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DoctorServiceMongoImpl implements IDoctorService {
    @Autowired
    DoctorRepository repository;

    @PostConstruct
    void init() {
        List<Doctor> doctors = new ArrayList<>(Arrays.asList(
                new Doctor("1","ikik", "assda", "adada", "+3802131313", '2'),
                new Doctor("2","olkjhgf", "assda", "saddw", "+380821931", '3'),
                new Doctor("3","ergh", "assda", "gfhfh", "+3809421414", '5')
        ));
        repository.saveAll(doctors);
    }


    @Override
    public Doctor save(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public Doctor get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Doctor> getAll() {
        return repository.findAll();
    }


    @Override
    public Doctor edit(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public Doctor delete(String id) {
        Doctor doctor = this.get(id);
        repository.deleteById(id);
        return doctor;
    }

    public List<Doctor> search(String word) {
        return this.getAll().stream()
                .filter(doctor -> doctor.getFIO()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Doctor> sortByFIO(List<Doctor> doctors){

        Collections.sort(doctors, new DoctorServiceMongoImpl.DoctorFioComparator());

        return doctors;
    }

    private class DoctorFioComparator implements Comparator<Doctor> {
        public int compare(Doctor d1, Doctor d2) {
            return d1.getFIO().compareTo(d2.getFIO());
        }
    }
}
