package com.example.BS9.infrastructure.dto.input;

import com.example.BS9.domain.Asignatura;
import com.example.BS9.domain.Persona;
import com.example.BS9.domain.Profesor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class EstudianteInputDTO implements Serializable {

    private String id;

    private int numeroHorasSemanales;

    private String rama;

    private String comentarios;

    private Persona persona;

    private Profesor profesor;

    private List<Asignatura> asignaturas;

}
