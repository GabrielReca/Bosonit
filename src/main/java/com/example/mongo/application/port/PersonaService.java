package com.example.mongo.application.port;

import com.example.mongo.infrastructure.dto.input.PersonaInputDTO;
import com.example.mongo.infrastructure.dto.output.PersonaOutputDTO;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTO anhadirPersona(PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO modificarPersona(Integer id, PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO buscarPorID(Integer id) throws Exception;

    List<PersonaOutputDTO> busquedaTodos();
    PersonaOutputDTO busquedaUsuario(String usuario) throws Exception;

    PersonaOutputDTO eliminarUsuario(Integer id) throws Exception;

}
