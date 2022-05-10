package com.example.BS9.infrastructure.repository;

import com.example.BS9.domain.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
    @Query("SELECT p FROM Persona p WHERE p.usuario = ?1")
    Persona buscarPersona(String usuario);

}
