package com.example.cors.application;

import com.example.cors.application.port.PersonaService;
import com.example.cors.domain.Persona;
import com.example.cors.infrastructure.dto.input.PersonaInputDTO;
import com.example.cors.infrastructure.dto.output.PersonaOutputDTO;
import com.example.cors.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository pr;

    @Override
    public PersonaOutputDTO anhadirPersona(PersonaInputDTO personaInputDTO) throws Exception {
        if(personaInputDTO.getUsuario() == null)
            throw new Exception("usuario puede ser nulo");
        else if(personaInputDTO.getUsuario().length() > 10 || personaInputDTO.getUsuario().length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            Persona persona = new Persona(personaInputDTO);
            pr.save(persona);
            PersonaOutputDTO personaDtoOuput = new PersonaOutputDTO(persona);
            return personaDtoOuput;
        }
    }

    @Override
    public List<PersonaOutputDTO> busquedaTodos() {
        List<Persona> lista = (List<Persona>) pr.findAll();
        List<PersonaOutputDTO> listaOutput = new ArrayList<>();

        for(Persona i: lista)
        {
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(i);
            listaOutput.add(personaOutputDTO);
        }

        return listaOutput;
    }
}
