package edu.andrew.kursach.service.visit.impls;

import edu.andrew.kursach.dao.repository.VisitRepository;
import edu.andrew.kursach.model.Doctor;
import edu.andrew.kursach.model.Patient;
import edu.andrew.kursach.model.Visit;
import edu.andrew.kursach.service.visit.interfaces.IVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VisitServiceMongoImpl implements IVisit {

    @Autowired
    VisitRepository repository;

    @PostConstruct
    void init() {
        List<Visit> visits = new ArrayList<>(Arrays.asList(
                new Visit("1",(new Patient("1", '1', "adada", "asdad", "+3802424242")),
                        (new Doctor("1","ikik", "assda",
                                "adada", "+3802131313", '2')),"wadada", "dadadaa","dadadada",
                        "dadad", '2', '3', '2'),
                new Visit("1",(new Patient("2", '1', "adada", "asdad", "+3802424242")),
                        (new Doctor("2","ikik", "assda",
                                "adada", "+3802131313", '2')),"wadada", "dadadaa","dadadada",
                        "dadad", '2', '3', '2'),
                new Visit("1",(new Patient("3", '1', "adada", "asdad", "+3802424242")),
                        (new Doctor("3","ikik", "assda",
                                "adada", "+3802131313", '2')),"wadada", "dadadaa","dadadada",
                        "dadad", '2', '3', '2')

        ));
        repository.saveAll(visits);
    }
    @Override
    public Visit save(Visit visit) {
        return repository.save(visit);
    }

    @Override
    public Visit get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Visit> getAll() {
        return repository.findAll();
    }

    @Override
    public Visit edit(Visit visit) {
        return repository.save(visit);
    }

    @Override
    public Visit delete(String id) {
        Visit visit = this.get(id);
        repository.deleteById(id);
        return visit;
    }

    public List<Visit> search(String word) {
        return this.getAll().stream()
                .filter(visit -> visit.getPatient().getFIO()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Visit> sortByPatient(List<Visit> visits){

        Collections.sort(visits, new VisitServiceMongoImpl.VisitPatientComparator());

        return visits;
    }

    private class VisitPatientComparator implements Comparator<Visit> {
        public int compare(Visit v1, Visit v2) {
            return v1.getPatient().getFIO()
                    .compareTo(v2.getPatient().getFIO());
        }
    }
}
