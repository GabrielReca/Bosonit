package com.example.DB2.infrastructure.dto.input;

import com.example.DB2.domain.AsignaturaDB2;
import com.example.DB2.domain.PersonaDB2;
import com.example.DB2.domain.ProfesorDB2;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class EstudianteInputDTO implements Serializable {

    private String id;

    private int numeroHorasSemanales;

    private String rama;

    private String comentarios;

    private PersonaDB2 persona;

    private ProfesorDB2 profesor;

    private List<AsignaturaDB2> asignaturas;

}
