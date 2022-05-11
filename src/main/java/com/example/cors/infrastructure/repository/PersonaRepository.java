package com.example.cors.infrastructure.repository;

import com.example.cors.domain.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
    @Query("SELECT p FROM Persona p WHERE p.usuario = ?1")
    Persona buscarPersona(String usuario);

}
