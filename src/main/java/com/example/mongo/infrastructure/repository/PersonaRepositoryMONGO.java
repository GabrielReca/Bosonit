package com.example.mongo.infrastructure.repository;

import com.example.mongo.domain.PersonaMONGO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepositoryMONGO extends MongoRepository<PersonaMONGO, Integer> {

}
