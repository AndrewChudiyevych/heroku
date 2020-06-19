package edu.andrew.kursach.dao.repository;

import edu.andrew.kursach.model.HistoryOfDiseases;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryOfDiseasesRepository extends MongoRepository<HistoryOfDiseases, String> {
}
