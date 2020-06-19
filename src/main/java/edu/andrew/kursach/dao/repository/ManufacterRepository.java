package edu.andrew.kursach.dao.repository;

import edu.andrew.kursach.model.Manufacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacterRepository extends MongoRepository<Manufacter, String> {
}
