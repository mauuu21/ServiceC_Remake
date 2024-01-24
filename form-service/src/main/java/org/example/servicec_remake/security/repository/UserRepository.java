package org.example.servicec_remake.security.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<UserDocument, UUID> {

    Optional<UserDocument> findByUsername(String username);
}
