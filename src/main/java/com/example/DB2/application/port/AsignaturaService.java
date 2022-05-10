package com.example.DB2.application.port;

import com.example.DB2.infrastructure.dto.input.AsignaturaInputDTO;
import com.example.DB2.infrastructure.dto.output.AsignaturaOutputDTO;
import com.example.DB2.infrastructure.dto.output.EstudianteAsignaturaOutputDTO;

public interface AsignaturaService {
    EstudianteAsignaturaOutputDTO buscarAsignaturasPorID(String id);

    AsignaturaOutputDTO crearAsignatura(AsignaturaInputDTO estudianteAsignaturaInputDTO);
}
