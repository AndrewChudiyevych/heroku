package edu.andrew.kursach.service.hostoryOfDiseases.impls;

import edu.andrew.kursach.dao.repository.HistoryOfDiseasesRepository;
import edu.andrew.kursach.model.*;
import edu.andrew.kursach.service.hostoryOfDiseases.interfaces.IHistoryOfDiseasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class HistoryOfDiseasesServiceMongoImpl implements IHistoryOfDiseasesService {
    @Autowired
    HistoryOfDiseasesRepository repository;

    @PostConstruct
    void init() {
        List<HistoryOfDiseases> historyOfDiseases = new ArrayList<>(Arrays.asList(
                new HistoryOfDiseases("1", (new Diseases("1", "dsfs", "sadad", "asdad")),
                        (new Patient("1", '1', "adada", "asdad", "+3802424242")),
                        (new Doctor("1","ikik", "assda", "adada", "+3802131313", '2')),
                        "dada", "dadada", "dadada", '2',
                        (new PatientSpendingCard("1",(new Patient("1", '1', "adada", "asdad", "+3802424242")),"1",'2','2', "dasda","adada"))),
                new HistoryOfDiseases("2", (new Diseases("1", "dsfs", "sadad", "asdad")),
                        (new Patient("1", '1', "adada", "asdad", "+3802424242")),
                        (new Doctor("1","ikik", "assda", "adada", "+3802131313", '2')),
                        "dada", "dadada", "dadada", '2',
                        (new PatientSpendingCard("1",(new Patient("1", '1', "adada", "asdad", "+3802424242")),"2",'2','2', "dasda","adada"))),
                new HistoryOfDiseases("3", (new Diseases("1", "dsfs", "sadad", "asdad")),
                        (new Patient("1", '1', "adada", "asdad", "+3802424242")),
                        (new Doctor("1","ikik", "sadada", "adada", "+3802131313", '2')),
                        "dada", "dadada", "dadada", '2',
                        (new PatientSpendingCard("1",(new Patient("1", '1', "adada", "asdad", "+3802424242")), "3",'2','2', "dasda","adada")))

        ));
        repository.saveAll(historyOfDiseases);
    }

    @Override
    public HistoryOfDiseases save(HistoryOfDiseases historyOfDiseases) {
        return repository.save(historyOfDiseases);
    }

    @Override
    public HistoryOfDiseases get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<HistoryOfDiseases> getAll() {
        return repository.findAll();
    }

    @Override
    public HistoryOfDiseases edit(HistoryOfDiseases historyOfDiseases) {
        return repository.save(historyOfDiseases);
    }

    @Override
    public HistoryOfDiseases delete(String id) {
        HistoryOfDiseases historyOfDiseases = this.get(id);
        repository.deleteById(id);
        return historyOfDiseases;
    }

    public List<HistoryOfDiseases> search(String word) {
        return this.getAll().stream()
                .filter(historyOfDiseases -> historyOfDiseases.getPatient().getFIO()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<HistoryOfDiseases> sortByPatientFio(List<HistoryOfDiseases> historyOfDiseases){

        Collections.sort(historyOfDiseases, new HistoryOfDiseasesServiceMongoImpl.HistoryOfDiseasesPatientFioComparator());

        return historyOfDiseases;
    }

    private class HistoryOfDiseasesPatientFioComparator implements Comparator<HistoryOfDiseases> {
        public int compare(HistoryOfDiseases h1, HistoryOfDiseases h2) {
            return h1.getPatient().getFIO()
                    .compareTo(h2.getPatient().getFIO());
        }
    }
}
