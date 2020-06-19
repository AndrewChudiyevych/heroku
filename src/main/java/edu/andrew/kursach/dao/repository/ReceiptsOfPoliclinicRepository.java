package edu.andrew.kursach.dao.repository;

import edu.andrew.kursach.model.ReceiptsOfPoliclinic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptsOfPoliclinicRepository extends MongoRepository<ReceiptsOfPoliclinic, String> {
}
