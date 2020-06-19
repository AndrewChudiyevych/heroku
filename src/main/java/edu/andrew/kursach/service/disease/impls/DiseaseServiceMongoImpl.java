package edu.andrew.kursach.service.disease.impls;


import edu.andrew.kursach.dao.repository.DiseasesRepository;
import edu.andrew.kursach.model.Diseases;
import edu.andrew.kursach.service.disease.interfaces.IDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DiseaseServiceMongoImpl implements IDiseaseService {

    @Autowired
    DiseasesRepository repository;

    @PostConstruct
    void init() {
        List<Diseases> diseases = new ArrayList<>(Arrays.asList(
                new Diseases("1","adadad", "sdsdsd", "adada"),
                new Diseases("2","asdafe", "dfggg", "saddw"),
                new Diseases("3","gfhtrhrh", "sffff", "gfhfh")
        ));
        repository.saveAll(diseases);
    }


    @Override
    public Diseases save(Diseases diseases) {
        return repository.save(diseases);
    }

    @Override
    public Diseases get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Diseases> getAll() {
        return repository.findAll();
    }

    @Override
    public Diseases edit(Diseases diseases) {
        return repository.save(diseases);
    }

    @Override
    public Diseases delete(String id) {
        Diseases diseases = this.get(id);
        repository.deleteById(id);
        return diseases;
    }

    public List<Diseases> search(String word) {
        return this.getAll().stream()
                .filter(diseases -> diseases.getNameOfDisease()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Diseases> sortByNameOfDisease(List<Diseases> diseases){

        Collections.sort(diseases, new DiseaseServiceMongoImpl.DiseaseNameComparator());

        return diseases;
    }

    private class DiseaseNameComparator implements Comparator<Diseases> {
        public int compare(Diseases d1, Diseases d2) {
            return d1.getNameOfDisease()
                    .compareTo(d2.getNameOfDisease());
        }
    }
}
