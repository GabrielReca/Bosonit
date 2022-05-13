package com.example.cors.infrastructure.repository;

import com.example.cors.domain.PersonaCORS;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositoryCORS extends CrudRepository<PersonaCORS, Integer> {
    @Query("SELECT p FROM Persona p WHERE p.usuario = ?1")
    PersonaCORS buscarPersona(String usuario);

}
