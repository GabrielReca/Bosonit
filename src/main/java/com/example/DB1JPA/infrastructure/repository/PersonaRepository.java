package com.example.DB1JPA.infrastructure.repository;

import com.example.DB1JPA.domain.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, String> {
    @Query("SELECT p FROM Persona p WHERE p.usuario = ?1")
    Persona buscarPersona(String usuario);

}
