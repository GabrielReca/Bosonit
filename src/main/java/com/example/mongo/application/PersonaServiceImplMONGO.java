package com.example.mongo.application;

import com.example.mongo.application.port.PersonaService;
import com.example.mongo.domain.PersonaMONGO;
import com.example.mongo.infrastructure.dto.input.PersonaInputDTO;
import com.example.mongo.infrastructure.dto.output.PersonaOutputDTO;
import com.example.mongo.infrastructure.repository.PersonaRepositoryMONGO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImplMONGO implements PersonaService {

    @Autowired
    PersonaRepositoryMONGO personaRepository;

    @Override
    public PersonaOutputDTO anhadirPersona(PersonaInputDTO personaInputDTO) throws Exception {
        if(personaInputDTO.getUsuario() == null)
            throw new Exception("usuario puede ser nulo");
        else if(personaInputDTO.getUsuario().length() > 10 || personaInputDTO.getUsuario().length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            PersonaMONGO persona = new PersonaMONGO(personaInputDTO);
            personaRepository.insert(persona);
            PersonaOutputDTO personaDtoOuput = new PersonaOutputDTO(persona);
            return personaDtoOuput;
        }
    }

    @Override
    public PersonaOutputDTO modificarPersona(Integer id, PersonaInputDTO personaInputDTO) throws Exception {
        if(personaInputDTO.getUsuario() == null)
            throw new Exception("usuario puede ser nulo");
        else if(personaInputDTO.getUsuario().length() > 10 || personaInputDTO.getUsuario().length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            PersonaMONGO persona = new PersonaMONGO(personaInputDTO);
            personaRepository.save(persona);
            PersonaOutputDTO personaDtoOuput = new PersonaOutputDTO(persona);
            return personaDtoOuput;
        }
    }

    @Override
    public PersonaOutputDTO buscarPorID(Integer id) throws Exception {
        PersonaMONGO persona = personaRepository.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
        return personaOutputDTO;
    }

    @Override
    public List<PersonaOutputDTO> busquedaTodos() {
        List<PersonaMONGO> lista = (List<PersonaMONGO>) personaRepository.findAll();
        List<PersonaOutputDTO> listaOutput = new ArrayList<>();

        for(PersonaMONGO i: lista)
        {
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(i);
            listaOutput.add(personaOutputDTO);
        }

        return listaOutput;
    }

    @Override
    public PersonaOutputDTO busquedaUsuario(String usuario) throws Exception {
        return null;
    }

  /*  @Override
    public PersonaOutputDTO busquedaUsuario(String usuario) throws Exception {
        if(usuario == null)
            throw new Exception("usuario puede ser nulo");
        else if(usuario.length() > 10 || usuario.length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            Persona persona = pr.buscarPersona(usuario);
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
            return personaOutputDTO;
        }
    }*/

    @Override
    public PersonaOutputDTO eliminarUsuario(Integer id) throws Exception {
        PersonaMONGO persona = personaRepository.findById(id).get();
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
        personaRepository.delete(persona);
        return personaOutputDTO;
    }
}
