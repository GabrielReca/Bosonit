package com.example.DB1JPA.application.port;

import com.example.DB1JPA.infrastructure.dto.input.PersonaInputDTO;
import com.example.DB1JPA.infrastructure.dto.output.PersonaOutputDTO;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTO anhadirPersona(PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO modificarPersona(String id, PersonaInputDTO personaInputDTO) throws Exception;


    PersonaOutputDTO buscarPorID(String id) throws Exception;


    List<PersonaOutputDTO> busquedaTodos();
    PersonaOutputDTO busquedaUsuario(String usuario) throws Exception;


    PersonaOutputDTO eliminarUsuario(String id) throws Exception;
}
