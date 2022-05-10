package com.example.BS9.infrastructure.dto.output;

import com.example.BS9.domain.Estudiante;
import com.example.BS9.domain.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaOutputDTO implements Serializable {

    private String id_asignatura;

    private String asignatura;

    private String comentarios;

    private Date fecha_inicial;

    private Date fecha_final;

    private List<Estudiante> estudiante;


    public AsignaturaOutputDTO(Asignatura estudianteAsignatura)
    {
        setId_asignatura(estudianteAsignatura.getId_asignatura());
        setAsignatura(estudianteAsignatura.getAsignatura());
        setComentarios(estudianteAsignatura.getComentarios());
        setFecha_inicial(estudianteAsignatura.getFecha_inicial());
        setFecha_final(estudianteAsignatura.getFecha_final());
        /*setId_profesor(estudianteAsignatura.getId_profesor());*/
    }
}
