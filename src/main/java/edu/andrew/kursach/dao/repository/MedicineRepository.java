package edu.andrew.kursach.dao.repository;

import edu.andrew.kursach.model.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends MongoRepository<Medicine, String> {
}
