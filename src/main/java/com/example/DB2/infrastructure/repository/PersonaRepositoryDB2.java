package com.example.DB2.infrastructure.repository;

import com.example.DB2.domain.PersonaDB2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositoryDB2 extends CrudRepository<PersonaDB2, Integer> {
    @Query("SELECT p FROM Persona p WHERE p.usuario = ?1")
    PersonaDB2 buscarPersona(String usuario);

}
