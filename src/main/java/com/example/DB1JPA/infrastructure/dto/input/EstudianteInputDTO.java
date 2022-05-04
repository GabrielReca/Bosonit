package com.example.DB1JPA.infrastructure.dto.input;

import com.example.DB1JPA.domain.Persona;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
public class EstudianteInputDTO implements Serializable {

    private String id;

    private int numeroHorasSemanales;

    private String rama;

    private String comentarios;

    private Persona persona;

    private String id_profesor;
}
