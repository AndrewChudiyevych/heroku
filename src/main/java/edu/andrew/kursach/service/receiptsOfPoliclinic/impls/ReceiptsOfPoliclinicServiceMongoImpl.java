package edu.andrew.kursach.service.receiptsOfPoliclinic.impls;

import edu.andrew.kursach.dao.repository.ReceiptsOfPoliclinicRepository;
import edu.andrew.kursach.model.ReceiptsOfPoliclinic;
import edu.andrew.kursach.service.receiptsOfPoliclinic.interfaces.IReceiptsOfPoliclinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReceiptsOfPoliclinicServiceMongoImpl implements IReceiptsOfPoliclinicService {

    @Autowired
    ReceiptsOfPoliclinicRepository repository;

    @PostConstruct
    void init() {
        List<ReceiptsOfPoliclinic> receiptsOfPoliclinics = new ArrayList<>(Arrays.asList(
                new ReceiptsOfPoliclinic("1",'2','2', "dasda","adada"),
                new ReceiptsOfPoliclinic("2",'2','2', "dasda","adada"),
                new ReceiptsOfPoliclinic("3",'2','2', "dasda","adada")


        ));
        repository.saveAll(receiptsOfPoliclinics);
    }
    @Override
    public ReceiptsOfPoliclinic save(ReceiptsOfPoliclinic receiptsOfPoliclinic) {
        return repository.save(receiptsOfPoliclinic);
    }

    @Override
    public ReceiptsOfPoliclinic get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ReceiptsOfPoliclinic> getAll() {
        return repository.findAll();
    }

    @Override
    public ReceiptsOfPoliclinic edit(ReceiptsOfPoliclinic receiptsOfPoliclinic) {
        return repository.save(receiptsOfPoliclinic);
    }

    @Override
    public ReceiptsOfPoliclinic delete(String id) {
        ReceiptsOfPoliclinic receiptsOfPoliclinic = this.get(id);
        repository.deleteById(id);
        return receiptsOfPoliclinic;
    }

    public List<ReceiptsOfPoliclinic> search(String word) {
        return this.getAll().stream()
                .filter(receiptsOfPoliclinic -> receiptsOfPoliclinic.getMonth()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ReceiptsOfPoliclinic> sortByMonth(List<ReceiptsOfPoliclinic> receiptsOfPoliclinics){

        Collections.sort(receiptsOfPoliclinics, new ReceiptsOfPoliclinicServiceMongoImpl.ReceiptsOfPoliclinicMonthComparator());

        return receiptsOfPoliclinics;
    }

    private class ReceiptsOfPoliclinicMonthComparator implements Comparator<ReceiptsOfPoliclinic> {
        public int compare(ReceiptsOfPoliclinic r1, ReceiptsOfPoliclinic r2) {
            return r1.getMonth()
                    .compareTo(r2.getMonth());
        }
    }
}
