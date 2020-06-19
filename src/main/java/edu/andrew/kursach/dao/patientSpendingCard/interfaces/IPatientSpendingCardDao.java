package edu.andrew.kursach.dao.patientSpendingCard.interfaces;

import edu.andrew.kursach.model.PatientSpendingCard;

import java.util.List;

public interface IPatientSpendingCardDao {
    PatientSpendingCard save(PatientSpendingCard patientSpendingCard);
    PatientSpendingCard get(String id);
    List<PatientSpendingCard> getAll();
    PatientSpendingCard edit(PatientSpendingCard patientSpendingCard);
    PatientSpendingCard delete(String id);
}
