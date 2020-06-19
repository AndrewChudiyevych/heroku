package edu.andrew.kursach.dao.repository;

import edu.andrew.kursach.model.Visit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends MongoRepository<Visit, String> {
}
