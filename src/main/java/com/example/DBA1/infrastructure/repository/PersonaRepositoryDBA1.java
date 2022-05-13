package com.example.DBA1.infrastructure.repository;

import com.example.DBA1.domain.PersonaDBA1;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface PersonaRepositoryDBA1 extends CrudRepository<PersonaDBA1, Integer> {
    @Query("SELECT p FROM Persona p WHERE p.usuario = ?1")
    PersonaDBA1 buscarPersona(String usuario);

    public List<PersonaDBA1> findByUsuario(HashMap<String, Object> conditions);

}
