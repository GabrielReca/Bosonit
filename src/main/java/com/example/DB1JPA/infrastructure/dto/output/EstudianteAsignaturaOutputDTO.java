package com.example.DB1JPA.infrastructure.dto.output;

import com.example.DB1JPA.domain.EstudianteAsignatura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteAsignaturaOutputDTO implements Serializable {

    private String id_asignatura;

    private String asignatura;

    private String comentarios;

    private Date fecha_inicial;

    private Date fecha_final;

    private String id_estudiante;

    private String id_profesor;

    public EstudianteAsignaturaOutputDTO(EstudianteAsignatura estudianteAsignatura)
    {
        setId_asignatura(estudianteAsignatura.getId_asignatura());
        setAsignatura(estudianteAsignatura.getAsignatura());
        setComentarios(estudianteAsignatura.getComentarios());
        setFecha_inicial(estudianteAsignatura.getFecha_inicial());
        setFecha_final(estudianteAsignatura.getFecha_final());
/*        setId_estudiante(estudianteAsignatura.getId_estudiante());
        setId_profesor(estudianteAsignatura.getId_profesor());*/
    }
}
