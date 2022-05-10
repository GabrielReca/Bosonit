package com.example.BS9.application;

import com.example.BS9.application.port.PersonaService;
import com.example.BS9.domain.Estudiante;
import com.example.BS9.domain.Persona;
import com.example.BS9.domain.Profesor;
import com.example.BS9.infrastructure.dto.input.PersonaInputDTO;
import com.example.BS9.infrastructure.dto.output.EstudiantePersonaOutputDTO;
import com.example.BS9.infrastructure.dto.output.PersonaOutputDTO;
import com.example.BS9.infrastructure.dto.output.ProfesorPersonaOutputDTO;
import com.example.BS9.infrastructure.repository.PersonaRepository;
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
    public PersonaOutputDTO modificarPersona(int id, PersonaInputDTO personaInputDTO) throws Exception {
        if(personaInputDTO.getUsuario() == null)
            throw new Exception("usuario puede ser nulo");
        else if(personaInputDTO.getUsuario().length() > 10 || personaInputDTO.getUsuario().length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            pr.deleteById(id);
            Persona persona = new Persona(personaInputDTO);
            pr.save(persona);
            PersonaOutputDTO personaDtoOuput = new PersonaOutputDTO(persona);
            return personaDtoOuput;
        }
    }

    @Override
    public PersonaOutputDTO buscarPorID(int id) throws Exception {
        Persona persona = pr.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
        return personaOutputDTO;
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

    @Override
    public EstudiantePersonaOutputDTO buscarAlumnoAsociado(int id) throws Exception {
        Persona persona = pr.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        Estudiante estudiante = persona.getEstudiante();
        EstudiantePersonaOutputDTO estudiantePersonaOutputDTO = new EstudiantePersonaOutputDTO(estudiante, persona);
        return estudiantePersonaOutputDTO;
    }

    @Override
    public EstudiantePersonaOutputDTO buscarAlumnoAsociadoPorUsuario(String usuario) throws Exception {
        Persona persona = pr.buscarPersona(usuario);
        Estudiante estudiante = persona.getEstudiante();
        EstudiantePersonaOutputDTO estudiantePersonaOutputDTO = new EstudiantePersonaOutputDTO(estudiante, persona);
        return estudiantePersonaOutputDTO;
    }

    @Override
    public ProfesorPersonaOutputDTO buscarProfesorAsociadoporUsuario(String usuario) throws Exception {
        Persona persona = pr.buscarPersona(usuario);
        Profesor profesor = persona.getProfesor();
        ProfesorPersonaOutputDTO profesorPersonaOutputDTO = new ProfesorPersonaOutputDTO(profesor, persona);
        return profesorPersonaOutputDTO;
    }

    @Override
    public ProfesorPersonaOutputDTO buscarProfesorAsociado(int id) throws Exception {
        Persona persona = pr.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        Profesor profesor = persona.getProfesor();
        ProfesorPersonaOutputDTO profesorPersonaOutputDTO = new ProfesorPersonaOutputDTO(profesor, persona);
        return profesorPersonaOutputDTO;
    }

    @Override
    public Persona GETgetProfesor(int id) {
        Persona persona = pr.findById(id).get();
        return persona;
    }

    @Override
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
    }

    @Override
    public PersonaOutputDTO eliminarUsuario(int id) throws Exception {
        Persona persona = pr.findById(id).get();
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
        pr.deleteById(id);
        return personaOutputDTO;
    }
}
