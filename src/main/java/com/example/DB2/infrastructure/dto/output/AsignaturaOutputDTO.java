package com.example.DB2.infrastructure.dto.output;

import com.example.DB2.domain.EstudianteDB2;
import com.example.DB2.domain.AsignaturaDB2;
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

    private List<EstudianteDB2> estudiante;


    public AsignaturaOutputDTO(AsignaturaDB2 estudianteAsignatura)
    {
        setId_asignatura(estudianteAsignatura.getId_asignatura());
        setAsignatura(estudianteAsignatura.getAsignatura());
        setComentarios(estudianteAsignatura.getComentarios());
        setFecha_inicial(estudianteAsignatura.getFecha_inicial());
        setFecha_final(estudianteAsignatura.getFecha_final());
        /*setId_profesor(estudianteAsignatura.getId_profesor());*/
    }
}
