package edu.andrew.kursach.service.patientSpendingCard.impls;

import edu.andrew.kursach.dao.patientSpendingCard.impls.PatientSpendingCardDaoImplFake;
import edu.andrew.kursach.model.PatientSpendingCard;
import edu.andrew.kursach.service.patientSpendingCard.interfaces.IPatientSpendingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PatientSpendingCardServiceImpl implements IPatientSpendingCardService {
    @Autowired
    PatientSpendingCardDaoImplFake dao;

    @PostConstruct
    void init() {
        List<PatientSpendingCard> list = dao.getAll();
        //repository.saveAll(list);
    }

    @Override
    public PatientSpendingCard save(PatientSpendingCard patientSpendingCard) {
        return null;
    }

    @Override
    public PatientSpendingCard get(String id) {
        return dao.getAll().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<PatientSpendingCard> getAll() {
        return dao.getAll();
    }

    @Override
    public PatientSpendingCard edit(PatientSpendingCard patientSpendingCard) {
        return null;
    }

    @Override
    public PatientSpendingCard delete(String id) {
        PatientSpendingCard patientSpendingCard = this.get(id);
        dao.getAll().remove(patientSpendingCard);
        return patientSpendingCard;
    }
}
