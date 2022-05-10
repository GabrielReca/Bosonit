package com.example.DB2.infrastructure.dto.output;

import com.example.DB2.domain.AsignaturaDB2;
import com.example.DB2.domain.EstudianteDB2;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EstudianteAsignaturaOutputDTO {

    private String id_estudiante;
    private List<AsignaturaDB2> asignaturas;

    public EstudianteAsignaturaOutputDTO(EstudianteDB2 estudiante)
    {
        setId_estudiante(estudiante.getId());
        setAsignaturas(estudiante.getAsignaturas());
    }
}
