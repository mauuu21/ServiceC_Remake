package org.example.servicec_remake.filledform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FilledFormRepository extends MongoRepository<FilledFormDocument, UUID> {
}
