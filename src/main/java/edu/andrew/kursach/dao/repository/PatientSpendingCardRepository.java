package edu.andrew.kursach.dao.repository;

import edu.andrew.kursach.model.PatientSpendingCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientSpendingCardRepository extends MongoRepository<PatientSpendingCard, String> {
}
