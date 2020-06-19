package edu.andrew.kursach.dao.repository;

import edu.andrew.kursach.model.Archive;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchiveRepository extends MongoRepository<Archive, String> {
}
