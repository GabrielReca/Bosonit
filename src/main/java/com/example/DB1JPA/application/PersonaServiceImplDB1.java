package com.example.DB1JPA.application;

import com.example.DB1JPA.application.port.PersonaService;
import com.example.DB1JPA.domain.PersonaDB1;
import com.example.DB1JPA.infrastructure.dto.input.PersonaInputDTO;
import com.example.DB1JPA.infrastructure.dto.output.PersonaOutputDTO;
import com.example.DB1JPA.infrastructure.repository.PersonaRepositoryDB1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImplDB1 implements PersonaService {

    @Autowired
    PersonaRepositoryDB1 pr;

    @Override
    public PersonaOutputDTO anhadirPersona(PersonaInputDTO personaInputDTO) throws Exception {
        if(personaInputDTO.getUsuario() == null)
            throw new Exception("usuario puede ser nulo");
        else if(personaInputDTO.getUsuario().length() > 10 || personaInputDTO.getUsuario().length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            PersonaDB1 persona = new PersonaDB1(personaInputDTO);
            pr.save(persona);
            PersonaOutputDTO personaDtoOuput = new PersonaOutputDTO(persona);
            return personaDtoOuput;
        }
    }

    @Override
    public PersonaOutputDTO modificarPersona(int id, PersonaInputDTO personaInputDTO) throws Exception {
        if(personaInputDTO.getUsuario() == null)
            throw new Exception("usuario puede ser nulo");
        else if(personaInputDTO.getUsuario().length() > 10 || personaInputDTO.getUsuario().length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            pr.deleteById(id);
            PersonaDB1 persona = new PersonaDB1(personaInputDTO);
            pr.save(persona);
            PersonaOutputDTO personaDtoOuput = new PersonaOutputDTO(persona);
            return personaDtoOuput;
        }
    }

    @Override
    public PersonaOutputDTO buscarPorID(int id) throws Exception {
        PersonaDB1 persona = pr.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
        return personaOutputDTO;
    }

    @Override
    public List<PersonaOutputDTO> busquedaTodos() {
        List<PersonaDB1> lista = (List<PersonaDB1>) pr.findAll();
        List<PersonaOutputDTO> listaOutput = new ArrayList<>();

        for(PersonaDB1 i: lista)
        {
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(i);
            listaOutput.add(personaOutputDTO);
        }

        return listaOutput;
    }

    @Override
    public PersonaOutputDTO busquedaUsuario(String usuario) throws Exception {
        if(usuario == null)
            throw new Exception("usuario puede ser nulo");
        else if(usuario.length() > 10 || usuario.length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            PersonaDB1 persona = pr.buscarPersona(usuario);
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
            return personaOutputDTO;
        }
    }

    @Override
    public PersonaOutputDTO eliminarUsuario(Integer id) throws Exception {
        PersonaDB1 persona = pr.findById(id).get();
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
        pr.deleteById(id);
        return personaOutputDTO;
    }
}
