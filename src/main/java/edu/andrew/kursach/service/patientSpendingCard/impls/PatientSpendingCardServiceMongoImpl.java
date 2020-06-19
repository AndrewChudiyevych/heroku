package edu.andrew.kursach.service.patientSpendingCard.impls;

import edu.andrew.kursach.dao.repository.PatientSpendingCardRepository;
import edu.andrew.kursach.model.Patient;
import edu.andrew.kursach.model.PatientSpendingCard;
import edu.andrew.kursach.service.patientSpendingCard.interfaces.IPatientSpendingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PatientSpendingCardServiceMongoImpl implements IPatientSpendingCardService {
    @Autowired
    PatientSpendingCardRepository repository;

    @PostConstruct
    void init() {
        List<PatientSpendingCard> patientSpendingCards = new ArrayList<>(Arrays.asList(
                new PatientSpendingCard("1",
                        (new Patient("1", '1', "adada", "asdad", "+3802424242")),
                        "1",'2','2', "dasda","adada"),
                new PatientSpendingCard("2",
                        (new Patient("1", '1', "adada", "asdad", "+3802424242")),
                        "2",'2','2', "dasda","adada"),
                new PatientSpendingCard("3",
                        (new Patient("1", '1', "adada", "asdad", "+3802424242")),
                        "3",'2','2', "dasda","adada")

        ));
        repository.saveAll(patientSpendingCards);
    }


    @Override
    public PatientSpendingCard save(PatientSpendingCard patientSpendingCard) {
        return repository.save(patientSpendingCard);
    }

    @Override
    public PatientSpendingCard get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PatientSpendingCard> getAll() {
        return repository.findAll();
    }

    @Override
    public PatientSpendingCard edit(PatientSpendingCard patientSpendingCard) {
        return repository.save(patientSpendingCard);
    }

    @Override
    public PatientSpendingCard delete(String id) {
        PatientSpendingCard patientSpendingCard = this.get(id);
        repository.deleteById(id);
        return patientSpendingCard;
    }

    public List<PatientSpendingCard> search(String word) {
        return this.getAll().stream()
                .filter(patientSpendingCard -> patientSpendingCard.getPatient().getFIO()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<PatientSpendingCard> sortByNumber(List<PatientSpendingCard> patientSpendingCards){

        Collections.sort(patientSpendingCards, new PatientSpendingCardServiceMongoImpl.SpendingCardNumberComparator());

        return patientSpendingCards;
    }

    private class SpendingCardNumberComparator implements Comparator<PatientSpendingCard> {
        public int compare(PatientSpendingCard p1, PatientSpendingCard p2) {
            return p1.getNumber()
                    .compareTo(p2.getNumber());
        }
    }
}
