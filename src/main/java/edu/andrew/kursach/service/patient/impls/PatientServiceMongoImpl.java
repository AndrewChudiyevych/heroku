package edu.andrew.kursach.service.patient.impls;

import edu.andrew.kursach.dao.repository.PatientRepository;
import edu.andrew.kursach.model.Patient;
import edu.andrew.kursach.service.patient.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PatientServiceMongoImpl implements IPatientService {
    @Autowired
    PatientRepository repository;

    @PostConstruct
    void init() {
        List<Patient> patients = new ArrayList<>(Arrays.asList(
                new Patient("1", '1', "adada", "asdad", "+3802424242"),
                new Patient("2", '2', "saddw", "wdwad", "+3801314444"),
                new Patient("3", '3', "Andrew", "wdwad", "+380138894444")
        ));
        repository.saveAll(patients);
    }


    @Override
    public Patient save(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public Patient get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Patient> getAll() {
        return repository.findAll();
    }

    @Override
    public Patient edit(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public Patient delete(String id) {
        Patient patient = this.get(id);
        repository.deleteById(id);
        return patient;
    }

    public List<Patient> search(String word) {
        return this.getAll().stream()
                .filter(patient -> patient.getFIO()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Patient> sortByFIO(List<Patient> patients){

        Collections.sort(patients, new PatientFioComparator());

        return patients;
    }

    private class PatientFioComparator implements Comparator<Patient> {
        public int compare(Patient p1, Patient p2) {
            return p1.getFIO().compareTo(p2.getFIO());
        }
    }
}
