package com.example.DBA1.application.port;

import com.example.DBA1.infrastructure.dto.input.PersonaInputDTO;
import com.example.DBA1.infrastructure.dto.output.PersonaOutputDTO;

import java.util.List;

public interface PersonaServiceDBA1 {
    PersonaOutputDTO anhadirPersona(PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO modificarPersona(int id, PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO buscarPorID(int id) throws Exception;

    List<PersonaOutputDTO> busquedaTodos();
    PersonaOutputDTO busquedaUsuario(String usuario) throws Exception;

    PersonaOutputDTO eliminarUsuario(Integer id) throws Exception;

}
