package com.example.JVA2.application;

import com.example.JVA2.application.port.PersonaService;
import com.example.JVA2.domain.PersonaJVA2;
import com.example.JVA2.infrastructure.dto.input.PersonaInputDTO;
import com.example.JVA2.infrastructure.dto.output.PersonaOutputDTO;
import com.example.JVA2.infrastructure.repository.PersonaRepositoryJVA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImplJVA2 implements PersonaService {

    @Autowired
    PersonaRepositoryJVA2 pr;

    @Override
    public PersonaOutputDTO anhadirPersona(PersonaInputDTO personaInputDTO) throws Exception {
        if(personaInputDTO.usuario() == null)
            throw new Exception("usuario puede ser nulo");
        else if(personaInputDTO.usuario().length() > 10 || personaInputDTO.usuario().length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            PersonaJVA2 persona = new PersonaJVA2(personaInputDTO);
            pr.save(persona);
            PersonaOutputDTO personaDtoOuput = pasarEntityAPersona(persona);
            return personaDtoOuput;
        }
    }

    @Override
    public PersonaOutputDTO modificarPersona(int id, PersonaInputDTO personaInputDTO) throws Exception {
        if(personaInputDTO.usuario() == null)
            throw new Exception("usuario puede ser nulo");
        else if(personaInputDTO.usuario().length() > 10 || personaInputDTO.usuario().length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            pr.deleteById(id);
            PersonaJVA2 persona = new PersonaJVA2(personaInputDTO);
            pr.save(persona);
            PersonaOutputDTO personaDtoOuput = pasarEntityAPersona(persona);
            return personaDtoOuput;
        }
    }

    @Override
    public PersonaOutputDTO buscarPorID(int id) throws Exception {
        PersonaJVA2 persona = pr.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        PersonaOutputDTO personaOutputDTO = pasarEntityAPersona(persona);
        return personaOutputDTO;
    }

    @Override
    public List<PersonaOutputDTO> busquedaTodos() {
        List<PersonaJVA2> lista = (List<PersonaJVA2>) pr.findAll();
        List<PersonaOutputDTO> listaOutput = new ArrayList<>();

        for(PersonaJVA2 i: lista)
        {
            PersonaOutputDTO personaOutputDTO = pasarEntityAPersona(i);
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
            PersonaJVA2 persona = pr.buscarPersona(usuario);
            PersonaOutputDTO personaOutputDTO = pasarEntityAPersona(persona);
            return personaOutputDTO;
        }
    }

    @Override
    public PersonaOutputDTO eliminarUsuario(Integer id) throws Exception {
        PersonaJVA2 persona = pr.findById(id).get();
        PersonaOutputDTO personaOutputDTO = pasarEntityAPersona(persona);
        pr.deleteById(id);
        return personaOutputDTO;
    }

    public PersonaOutputDTO pasarEntityAPersona(PersonaJVA2 persona){
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona.getId(), persona.getUsuario(), persona.getPassword(), persona.getName(), persona.getSurname(), persona.getCompany_email(), persona.getPersonal_email(), persona.getCity(), persona.isActive(), persona.getCreated_date(), persona.getImagen_url(), persona.getTermination_date());
        return personaOutputDTO;
    }
}
