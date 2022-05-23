package com.example.DB1JPA.application.port;

import com.example.DB1JPA.domain.PersonaDB1;
import com.example.DB1JPA.infrastructure.dto.input.PersonaInputDTO;

import java.util.List;

public interface PersonaServiceDB1 {


    PersonaDB1 anhadirPersona(PersonaInputDTO personaInputDTO) throws ClassNotFoundException;
    PersonaDB1 modificarPersona(int id, PersonaInputDTO personaInputDTO) throws ClassNotFoundException;
    PersonaDB1 buscarPorID(Integer id) throws ClassNotFoundException;

    List<PersonaDB1> busquedaTodos() throws ClassNotFoundException;
    PersonaDB1 busquedaUsuario(String usuario) throws ClassNotFoundException;

    PersonaDB1 eliminarUsuario(Integer id) throws ClassNotFoundException;

}
