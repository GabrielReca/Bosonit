package com.example.DB1JPA.infrastructure.repository;

import com.example.DB1JPA.domain.PersonaDB1;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositoryDB1 extends CrudRepository<PersonaDB1, Integer> {
    @Query("SELECT p FROM Persona p WHERE p.usuario = ?1")
    PersonaDB1 buscarPersona(String usuario);

}
