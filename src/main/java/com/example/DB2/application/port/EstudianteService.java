package com.example.DB2.application.port;

import com.example.DB2.infrastructure.dto.input.EstudianteInputDTO;
import com.example.DB2.infrastructure.dto.output.EstudianteOutputDTO;
import com.example.DB2.infrastructure.dto.output.EstudiantePersonaOutputDTO;

import java.util.List;

public interface EstudianteService {

    EstudianteOutputDTO buscarPorID(String id) throws Exception;

    EstudiantePersonaOutputDTO buscarPorIDFull(String id) throws Exception;

    List<EstudiantePersonaOutputDTO> busquedaTodosFull() throws Exception;
    EstudiantePersonaOutputDTO busquedaPorUsuario(String usuario) throws Exception;

    EstudianteOutputDTO anhadirEstudiante(EstudianteInputDTO estudianteInputDTO) throws Exception;

    EstudianteOutputDTO modificarEstudiante(String id, EstudianteInputDTO estudianteInputDTO) throws Exception;

    EstudianteOutputDTO eliminarUsuario(String id) throws Exception;
}
