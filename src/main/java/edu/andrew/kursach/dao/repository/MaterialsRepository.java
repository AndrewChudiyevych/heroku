package edu.andrew.kursach.dao.repository;

import edu.andrew.kursach.model.Materials;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialsRepository extends MongoRepository<Materials, String> {
}
