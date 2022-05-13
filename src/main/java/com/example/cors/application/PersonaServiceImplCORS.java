package com.example.cors.application;

import com.example.cors.application.port.PersonaService;
import com.example.cors.domain.PersonaCORS;
import com.example.cors.infrastructure.dto.input.PersonaInputDTO;
import com.example.cors.infrastructure.dto.output.PersonaOutputDTO;
import com.example.cors.infrastructure.repository.PersonaRepositoryCORS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImplCORS implements PersonaService {

    @Autowired
    PersonaRepositoryCORS pr;

    @Override
    public PersonaOutputDTO anhadirPersona(PersonaInputDTO personaInputDTO) throws Exception {
        if(personaInputDTO.getUsuario() == null)
            throw new Exception("usuario puede ser nulo");
        else if(personaInputDTO.getUsuario().length() > 10 || personaInputDTO.getUsuario().length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            PersonaCORS persona = new PersonaCORS(personaInputDTO);
            pr.save(persona);
            PersonaOutputDTO personaDtoOuput = new PersonaOutputDTO(persona);
            return personaDtoOuput;
        }
    }

    @Override
    public List<PersonaOutputDTO> busquedaTodos() {
        List<PersonaCORS> lista = (List<PersonaCORS>) pr.findAll();
        List<PersonaOutputDTO> listaOutput = new ArrayList<>();

        for(PersonaCORS i: lista)
        {
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(i);
            listaOutput.add(personaOutputDTO);
        }

        return listaOutput;
    }
}
