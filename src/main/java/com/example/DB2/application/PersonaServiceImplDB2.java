package com.example.DB2.application;

import com.example.DB2.application.port.PersonaService;
import com.example.DB2.domain.EstudianteDB2;
import com.example.DB2.domain.PersonaDB2;
import com.example.DB2.domain.ProfesorDB2;
import com.example.DB2.infrastructure.dto.input.PersonaInputDTO;
import com.example.DB2.infrastructure.dto.output.EstudiantePersonaOutputDTO;
import com.example.DB2.infrastructure.dto.output.PersonaOutputDTO;
import com.example.DB2.infrastructure.dto.output.ProfesorPersonaOutputDTO;
import com.example.DB2.infrastructure.repository.PersonaRepositoryDB2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImplDB2 implements PersonaService {

    @Autowired
    PersonaRepositoryDB2 pr;

    @Override
    public PersonaOutputDTO anhadirPersona(PersonaInputDTO personaInputDTO) throws Exception {
        if(personaInputDTO.getUsuario() == null)
            throw new Exception("usuario puede ser nulo");
        else if(personaInputDTO.getUsuario().length() > 10 || personaInputDTO.getUsuario().length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            PersonaDB2 persona = new PersonaDB2(personaInputDTO);
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
            PersonaDB2 persona = new PersonaDB2(personaInputDTO);
            pr.save(persona);
            PersonaOutputDTO personaDtoOuput = new PersonaOutputDTO(persona);
            return personaDtoOuput;
        }
    }

    @Override
    public PersonaOutputDTO buscarPorID(int id) throws Exception {
        PersonaDB2 persona = pr.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
        return personaOutputDTO;
    }

    @Override
    public List<PersonaOutputDTO> busquedaTodos() {
        List<PersonaDB2> lista = (List<PersonaDB2>) pr.findAll();
        List<PersonaOutputDTO> listaOutput = new ArrayList<>();

        for(PersonaDB2 i: lista)
        {
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(i);
            listaOutput.add(personaOutputDTO);
        }

        return listaOutput;
    }

    @Override
    public EstudiantePersonaOutputDTO buscarAlumnoAsociado(int id) throws Exception {
        PersonaDB2 persona = pr.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        EstudianteDB2 estudiante = persona.getEstudiante();
        EstudiantePersonaOutputDTO estudiantePersonaOutputDTO = new EstudiantePersonaOutputDTO(estudiante, persona);
        return estudiantePersonaOutputDTO;
    }

    @Override
    public EstudiantePersonaOutputDTO buscarAlumnoAsociadoPorUsuario(String usuario) throws Exception {
        PersonaDB2 persona = pr.buscarPersona(usuario);
        EstudianteDB2 estudiante = persona.getEstudiante();
        EstudiantePersonaOutputDTO estudiantePersonaOutputDTO = new EstudiantePersonaOutputDTO(estudiante, persona);
        return estudiantePersonaOutputDTO;
    }

    @Override
    public ProfesorPersonaOutputDTO buscarProfesorAsociadoporUsuario(String usuario) throws Exception {
        PersonaDB2 persona = pr.buscarPersona(usuario);
        ProfesorDB2 profesor = persona.getProfesor();
        ProfesorPersonaOutputDTO profesorPersonaOutputDTO = new ProfesorPersonaOutputDTO(profesor, persona);
        return profesorPersonaOutputDTO;
    }

    @Override
    public ProfesorPersonaOutputDTO buscarProfesorAsociado(int id) throws Exception {
        PersonaDB2 persona = pr.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        ProfesorDB2 profesor = persona.getProfesor();
        ProfesorPersonaOutputDTO profesorPersonaOutputDTO = new ProfesorPersonaOutputDTO(profesor, persona);
        return profesorPersonaOutputDTO;
    }

    @Override
    public PersonaOutputDTO busquedaUsuario(String usuario) throws Exception {
        if(usuario == null)
            throw new Exception("usuario puede ser nulo");
        else if(usuario.length() > 10 || usuario.length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            PersonaDB2 persona = pr.buscarPersona(usuario);
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
            return personaOutputDTO;
        }
    }

    @Override
    public PersonaOutputDTO eliminarUsuario(int id) throws Exception {
        PersonaDB2 persona = pr.findById(id).get();
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
        pr.deleteById(id);
        return personaOutputDTO;
    }
}
