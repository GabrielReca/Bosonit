package com.example.JVA2.infrastructure.repository;

import com.example.JVA2.domain.PersonaJVA2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositoryJVA2 extends CrudRepository<PersonaJVA2, Integer> {
    @Query("SELECT p FROM Persona p WHERE p.usuario = ?1")
    PersonaJVA2 buscarPersona(String usuario);

}
