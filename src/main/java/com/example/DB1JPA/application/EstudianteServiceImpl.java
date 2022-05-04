package com.example.DB1JPA.application;

import com.example.DB1JPA.application.port.EstudianteService;
import com.example.DB1JPA.domain.Estudiante;
import com.example.DB1JPA.domain.Persona;
import com.example.DB1JPA.infrastructure.dto.input.EstudianteInputDTO;
import com.example.DB1JPA.infrastructure.dto.output.EstudianteOutputDTO;
import com.example.DB1JPA.infrastructure.dto.output.EstudiantePersonaOutputDTO;
import com.example.DB1JPA.infrastructure.repository.EstudianteRepository;
import com.example.DB1JPA.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    EstudianteRepository er;

    @Autowired
    PersonaRepository pr;

    @Override
    public EstudianteOutputDTO buscarPorID(String id) throws Exception {
        Estudiante estudiante = er.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        EstudianteOutputDTO estudianteOutputDTO = new EstudianteOutputDTO(estudiante);
        return estudianteOutputDTO;
    }

    @Override
    public EstudiantePersonaOutputDTO buscarPorIDFull(String id) throws Exception {
        Estudiante estudiante = er.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        Persona persona = estudiante.getPersona();
        EstudiantePersonaOutputDTO estudiantePersonaOutputDTO = new EstudiantePersonaOutputDTO(estudiante, persona);
        return estudiantePersonaOutputDTO;
    }

    @Override
    public List<EstudianteOutputDTO> busquedaTodos() {
        List<Estudiante> lista = (List<Estudiante>) er.findAll();
        List<EstudianteOutputDTO> listaOutput = new ArrayList<>();

        for(Estudiante i: lista)
        {
            EstudianteOutputDTO estudianteOutputDTO = new EstudianteOutputDTO(i);
            listaOutput.add(estudianteOutputDTO);
        }

        return listaOutput;
    }
    @Override
    public EstudianteOutputDTO anhadirEstudiante(EstudianteInputDTO estudianteInputDTO){
            Estudiante estudiante = new Estudiante(estudianteInputDTO);
            er.save(estudiante);
            EstudianteOutputDTO estudianteOutputDTO = new EstudianteOutputDTO(estudiante);
            return estudianteOutputDTO;
    }

    @Override
    public EstudianteOutputDTO modificarEstudiante(String  id, EstudianteInputDTO estudianteInputDTO) throws Exception {
        if(estudianteInputDTO.getId() == null)
            throw new Exception("usuario puede ser nulo");
        else if(estudianteInputDTO.getId().length() > 10)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            er.deleteById(id);
            Estudiante estudiante = new Estudiante(estudianteInputDTO);
            er.save(estudiante);
            EstudianteOutputDTO estudianteOutputDTO = new EstudianteOutputDTO(estudiante);
            return estudianteOutputDTO;
        }
    }

    @Override
    public EstudianteOutputDTO eliminarUsuario(String id) throws Exception {
        Estudiante estudiante = er.findById(id).get();
        EstudianteOutputDTO estudianteOutputDTO = new EstudianteOutputDTO(estudiante);
        er.deleteById(id);
        return estudianteOutputDTO;
    }
}
