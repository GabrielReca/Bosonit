package com.example.DB1JPA.service;

import com.example.DB1JPA.infrastructure.PersonaInputDTO;
import com.example.DB1JPA.infrastructure.PersonaOutputDTO;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTO anhadirPersona(PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO modificarPersona(int id, PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO buscarPorID(int id) throws Exception;

    List<PersonaOutputDTO> busquedaTodos();
    PersonaOutputDTO busquedaUsuario(String usuario) throws Exception;

    PersonaOutputDTO eliminarUsuario(Integer id) throws Exception;

}
