package edu.andrew.kursach.service.receiptsOfDoctors.impls;

import edu.andrew.kursach.dao.repository.ReceiptsOfDoctorsRepository;
import edu.andrew.kursach.model.Doctor;
import edu.andrew.kursach.model.ReceiptsOfDoctors;
import edu.andrew.kursach.service.receiptsOfDoctors.interfaces.IReceiptsOfDoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReceiptsOfDoctorsServiceMongoImpl implements IReceiptsOfDoctorsService {

    @Autowired
    ReceiptsOfDoctorsRepository repository;

    @PostConstruct
    void init() {
        List<ReceiptsOfDoctors> receiptsOfDoctors = new ArrayList<>(Arrays.asList(
                new ReceiptsOfDoctors("1",(new Doctor("1","ikik", "assda",
                        "adada", "+3802131313", '2')),'2','2', "dasda","adada"),
                new ReceiptsOfDoctors("2",(new Doctor("2","ikik", "assda",
                        "adada", "+3802131313", '2')),'2','2', "dasda","adada"),
                new ReceiptsOfDoctors("3",(new Doctor("3","ikik", "assda",
                        "adada", "+3802131313", '2')),'2','2', "dasda","adada")

        ));
        repository.saveAll(receiptsOfDoctors);
    }


    @Override
    public ReceiptsOfDoctors save(ReceiptsOfDoctors receiptsOfDoctors) {
        return repository.save(receiptsOfDoctors);
    }

    @Override
    public ReceiptsOfDoctors get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ReceiptsOfDoctors> getAll() {
        return repository.findAll();
    }

    @Override
    public ReceiptsOfDoctors edit(ReceiptsOfDoctors receiptsOfDoctors) {
        return repository.save(receiptsOfDoctors);
    }

    @Override
    public ReceiptsOfDoctors delete(String id) {
        ReceiptsOfDoctors receiptsOfDoctors = this.get(id);
        repository.deleteById(id);
        return receiptsOfDoctors;
    }

    public List<ReceiptsOfDoctors> search(String word) {
        return this.getAll().stream()
                .filter(receiptsOfDoctors -> receiptsOfDoctors.getDoctor().getFIO()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ReceiptsOfDoctors> sortByDoctorFIO(List<ReceiptsOfDoctors> receiptsOfDoctors){

        Collections.sort(receiptsOfDoctors, new ReceiptsOfDoctorsServiceMongoImpl.ReceiptsOfDoctorFIOComparator());

        return receiptsOfDoctors;
    }

    private class ReceiptsOfDoctorFIOComparator implements Comparator<ReceiptsOfDoctors> {
        public int compare(ReceiptsOfDoctors r1, ReceiptsOfDoctors r2) {
            return r1.getDoctor().getFIO()
                    .compareTo(r2.getDoctor().getFIO());
        }
    }
}
