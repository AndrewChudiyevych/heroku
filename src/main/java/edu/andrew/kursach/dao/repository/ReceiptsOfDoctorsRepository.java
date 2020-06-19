package edu.andrew.kursach.dao.repository;

import edu.andrew.kursach.model.ReceiptsOfDoctors;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptsOfDoctorsRepository extends MongoRepository<ReceiptsOfDoctors, String> {
}
