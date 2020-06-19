package edu.andrew.kursach.service.visitsOfClinic.impls;

import edu.andrew.kursach.dao.repository.VisitsOfCliclinicRepository;
import edu.andrew.kursach.model.VisitsOfClinic;
import edu.andrew.kursach.service.visitsOfClinic.interfaces.IVisitsOfClinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VisitsOfClinicServiceMongoImpl implements IVisitsOfClinic {

    @Autowired
    VisitsOfCliclinicRepository repository;

    @PostConstruct
    void init() {
        List<VisitsOfClinic> visitsOfClinics = new ArrayList<>(Arrays.asList(
                new VisitsOfClinic("1",'3', '4', "dsss", "ssdssd"),
                new VisitsOfClinic("2",'3', '4', "dsss", "ssdssd"),
                new VisitsOfClinic("3",'3', '4', "dsss", "ssdssd")


        ));
        repository.saveAll(visitsOfClinics);
    }


    @Override
    public VisitsOfClinic save(VisitsOfClinic visitsOfClinic) {
        return repository.save(visitsOfClinic);
    }

    @Override
    public VisitsOfClinic get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<VisitsOfClinic> getAll() {
        return repository.findAll();
    }

    @Override
    public VisitsOfClinic edit(VisitsOfClinic visitsOfClinic) {
        return repository.save(visitsOfClinic);
    }

    @Override
    public VisitsOfClinic delete(String id) {
        VisitsOfClinic visitsOfClinic = this.get(id);
        repository.deleteById(id);
        return visitsOfClinic;
    }

    public List<VisitsOfClinic> search(String word) {
        return this.getAll().stream()
                .filter(visitsOfClinic -> visitsOfClinic.getMonth()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<VisitsOfClinic> sortByMonth(List<VisitsOfClinic> visitsOfClinics){

        Collections.sort(visitsOfClinics, new VisitsOfClinicServiceMongoImpl.VisitsOfClinicMonthComparator());

        return visitsOfClinics;
    }

    private class VisitsOfClinicMonthComparator implements Comparator<VisitsOfClinic> {
        public int compare(VisitsOfClinic v1, VisitsOfClinic v2) {
            return v1.getMonth()
                    .compareTo(v2.getMonth());
        }
    }
}
