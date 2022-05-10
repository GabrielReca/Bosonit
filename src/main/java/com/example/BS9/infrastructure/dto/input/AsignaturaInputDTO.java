package com.example.BS9.infrastructure.dto.input;

import com.example.BS9.domain.Estudiante;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AsignaturaInputDTO implements Serializable {

    private String id_asignatura;

    private String asignatura;

    private String comentarios;

    private Date fecha_inicial;

    private Date fecha_final;

    private List<Estudiante> estudiante;

/*    private String id_profesor;*/
}
