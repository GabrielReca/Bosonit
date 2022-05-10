package com.example.BS9.application.port;

import com.example.BS9.infrastructure.dto.input.AsignaturaInputDTO;
import com.example.BS9.infrastructure.dto.output.AsignaturaOutputDTO;
import com.example.BS9.infrastructure.dto.output.EstudianteAsignaturaOutputDTO;

public interface AsignaturaService {
    EstudianteAsignaturaOutputDTO buscarAsignaturasPorID(String id);

    AsignaturaOutputDTO crearAsignatura(AsignaturaInputDTO estudianteAsignaturaInputDTO);
}
