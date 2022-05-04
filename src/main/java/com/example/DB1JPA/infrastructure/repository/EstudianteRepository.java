package com.example.DB1JPA.infrastructure.repository;

import com.example.DB1JPA.domain.Estudiante;
import com.example.DB1JPA.domain.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<Estudiante, String> {

}
