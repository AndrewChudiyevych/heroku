package edu.andrew.kursach.service.material.impls;

import edu.andrew.kursach.dao.repository.MaterialsRepository;
import edu.andrew.kursach.model.Diseases;
import edu.andrew.kursach.model.Manufacter;
import edu.andrew.kursach.model.Materials;
import edu.andrew.kursach.service.material.interfaces.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MaterialServiceMongoImpl implements IMaterialService {
    @Autowired
    MaterialsRepository repository;

    @PostConstruct
    void init() {
        List<Materials> materials = new ArrayList<>(Arrays.asList(
                new Materials("1", (new Manufacter("1","dada","dasda"
                )), '9', "sdsdsd","kokoo",
                        (new Diseases("1", "dsfs", "sadad", "asdad"))),
                new Materials("2", (new Manufacter("2","tret","juyjj"
                )), '1', "syryr","kry6",
                        (new Diseases("2", "ytrr", "tfft", "hytht")))
        ));
        repository.saveAll(materials);
    }

    @Override
    public Materials save(Materials materials) {
        return repository.save(materials);
    }

    @Override
    public Materials get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Materials> getAll() {
        return repository.findAll();
    }

    @Override
    public Materials edit(Materials materials) {
        return repository.save(materials);
    }

    @Override
    public Materials delete(String id) {
        Materials materials = this.get(id);
        repository.deleteById(id);
        return materials;
    }

    public List<Materials> search(String word) {
        return this.getAll().stream()
                .filter(materials -> materials.getNameOfMaterial()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Materials> sortByNameOfMaterial(List<Materials> materials){

        Collections.sort(materials, new MaterialServiceMongoImpl.MaterialNameComparator());

        return materials;
    }

    private class MaterialNameComparator implements Comparator<Materials> {
        public int compare(Materials m1, Materials m2) {
            return m1.getNameOfMaterial()
                    .compareTo(m2.getNameOfMaterial());
        }
    }
}
