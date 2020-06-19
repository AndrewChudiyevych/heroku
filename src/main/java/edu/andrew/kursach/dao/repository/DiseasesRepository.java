package edu.andrew.kursach.dao.repository;

import edu.andrew.kursach.model.Diseases;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseasesRepository extends MongoRepository<Diseases, String> {
}
