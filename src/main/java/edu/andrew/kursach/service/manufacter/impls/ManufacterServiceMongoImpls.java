package edu.andrew.kursach.service.manufacter.impls;

import edu.andrew.kursach.dao.repository.ManufacterRepository;
import edu.andrew.kursach.model.Manufacter;
import edu.andrew.kursach.service.manufacter.interfaces.IManufacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ManufacterServiceMongoImpls implements IManufacterService {

    @Autowired
    ManufacterRepository repository;

    @PostConstruct
    void init() {
        List<Manufacter> manufacters = new ArrayList<>(Arrays.asList(
                new Manufacter("1","adadad", "sdsdsd"),
                new Manufacter("2","asdafe", "dfggg"),
                new Manufacter("3","gfhtrhrh", "sffff")
        ));
        repository.saveAll(manufacters);
    }


    @Override
    public Manufacter save(Manufacter manufacter) {
        return repository.save(manufacter);
    }

    @Override
    public Manufacter get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Manufacter> getAll() {
        return repository.findAll();
    }

    @Override
    public Manufacter edit(Manufacter manufacter) {
        return repository.save(manufacter);
    }

    @Override
    public Manufacter delete(String id) {
        Manufacter manufacter = this.get(id);
        repository.deleteById(id);
        return manufacter;
    }

    public List<Manufacter> search(String word) {
        return this.getAll().stream()
                .filter(manufacter -> manufacter.getName()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Manufacter> sortByName(List<Manufacter> manufacters){

        Collections.sort(manufacters, new ManufacterServiceMongoImpls.ManufacterNameComparator());

        return manufacters;
    }

    private class ManufacterNameComparator implements Comparator<Manufacter> {
        public int compare(Manufacter m1, Manufacter m2) {
            return m1.getName()
                    .compareTo(m2.getName());
        }
    }
}
