package com.example.DB1JPA.infrastructure.dto.input;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class EstudianteAsignaturaInputDTO implements Serializable {

    private String id_asignatura;

    private String asignatura;

    private String comentarios;

    private Date fecha_inicial;

    private Date fecha_final;

    private String id_estudiante;

    private String id_profesor;
}
