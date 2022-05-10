package com.example.BS9.application.port;

import com.example.BS9.infrastructure.dto.input.ProfesorInputDTO;
import com.example.BS9.infrastructure.dto.output.ProfesorOutputDTO;
import com.example.BS9.infrastructure.dto.output.ProfesorPersonaOutputDTO;

import java.util.List;

public interface ProfesorService {

    ProfesorOutputDTO buscarPorID(String id) throws Exception;
    ProfesorOutputDTO buscarPorID_Persona(int id) throws Exception;

    ProfesorPersonaOutputDTO buscarPorIDFull(String id) throws Exception;

    List<ProfesorPersonaOutputDTO> buscarTodosFull();

    ProfesorOutputDTO anhadirProfesor(ProfesorInputDTO profesorInputDTO) throws Exception;

    ProfesorOutputDTO modificarProfesor(String id, ProfesorInputDTO profesorInputDTO) throws Exception;

    ProfesorOutputDTO eliminarProfesor(String id) throws Exception;
}
