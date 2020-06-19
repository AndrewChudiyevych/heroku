package edu.andrew.kursach.service.medicine.impls;

import edu.andrew.kursach.dao.repository.MedicineRepository;
import edu.andrew.kursach.model.Diseases;
import edu.andrew.kursach.model.Manufacter;
import edu.andrew.kursach.model.Medicine;
import edu.andrew.kursach.service.medicine.interfaces.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MedicineServiceMongoImpl implements IMedicineService {

    @Autowired
    MedicineRepository repository;

    @PostConstruct
    void init() {
        List<Medicine> medicines = new ArrayList<>(Arrays.asList(
                new Medicine("1", (new Manufacter("1","dada","dasda"
                )), '9', "sdsdsd","kokoo",
                        (new Diseases("1", "dsfs", "sadad", "asdad"))),
                new Medicine("2", (new Manufacter("2","tret","juyjj"
                )), '1', "syryr","kry6",
                        (new Diseases("2", "ytrr", "tfft", "hytht")))
        ));
        repository.saveAll(medicines);
    }

    @Override
    public Medicine save(Medicine medicine) {
        return repository.save(medicine);
    }

    @Override
    public Medicine get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Medicine> getAll() {
        return repository.findAll();
    }

    @Override
    public Medicine edit(Medicine medicine) {
        return repository.save(medicine);
    }

    @Override
    public Medicine delete(String id) {
        Medicine medicine = this.get(id);
        repository.deleteById(id);
        return medicine;
    }

    public List<Medicine> search(String word) {
        return this.getAll().stream()
                .filter(medicine -> medicine.getNameOfMedicine()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Medicine> sortByNameOfMedicine(List<Medicine> medicines){

        Collections.sort(medicines, new MedicineServiceMongoImpl.MedicineNameComparator());

        return medicines;
    }

    private class MedicineNameComparator implements Comparator<Medicine> {
        public int compare(Medicine m1, Medicine m2) {
            return m1.getNameOfMedicine()
                    .compareTo(m2.getNameOfMedicine());
        }
    }
}
