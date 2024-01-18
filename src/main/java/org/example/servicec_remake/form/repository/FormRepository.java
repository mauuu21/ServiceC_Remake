package org.example.servicec_remake.form.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FormRepository extends MongoRepository<FormDocument, UUID> {
}
