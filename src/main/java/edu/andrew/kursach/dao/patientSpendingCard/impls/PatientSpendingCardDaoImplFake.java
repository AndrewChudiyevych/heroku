package edu.andrew.kursach.dao.patientSpendingCard.impls;

import edu.andrew.kursach.dao.patientSpendingCard.interfaces.IPatientSpendingCardDao;
import edu.andrew.kursach.dataSet.DataSet;
import edu.andrew.kursach.model.PatientSpendingCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientSpendingCardDaoImplFake implements IPatientSpendingCardDao {
    @Autowired
    DataSet dataSet;

    @Override
    public PatientSpendingCard save(PatientSpendingCard patientSpendingCard) {
        dataSet.getPatientSpendingCards().add(patientSpendingCard);
        return patientSpendingCard;
    }

    @Override
    public PatientSpendingCard get(String id) {
        return null;
    }

    @Override
    public List<PatientSpendingCard> getAll() {
        return this.dataSet.getPatientSpendingCards();
    }

    @Override
    public PatientSpendingCard edit(PatientSpendingCard patientSpendingCard) {
        return null;
    }

    @Override
    public PatientSpendingCard delete(String id) {
        return null;
    }
}
