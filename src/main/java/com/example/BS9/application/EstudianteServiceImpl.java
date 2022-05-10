package com.example.BS9.application;

import com.example.BS9.application.port.EstudianteService;
import com.example.BS9.domain.Estudiante;
import com.example.BS9.domain.Persona;
import com.example.BS9.infrastructure.dto.input.EstudianteInputDTO;
import com.example.BS9.infrastructure.dto.output.EstudianteOutputDTO;
import com.example.BS9.infrastructure.dto.output.EstudiantePersonaOutputDTO;
import com.example.BS9.infrastructure.repository.EstudianteRepository;
import com.example.BS9.infrastructure.repository.PersonaRepository;
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
        Estudiante estudiante = er.findById(id).get();
        Persona persona = estudiante.getPersona();
        EstudiantePersonaOutputDTO estudiantePersonaOutputDTO = new EstudiantePersonaOutputDTO(estudiante, persona);
        return estudiantePersonaOutputDTO;
    }

    @Override
    public List<EstudiantePersonaOutputDTO> busquedaTodosFull() throws Exception {
        List<Estudiante> listaEst = (List<Estudiante>) er.findAll();
        List<EstudiantePersonaOutputDTO> listaOutput = new ArrayList<>();

        for(Estudiante i: listaEst)
        {
            Persona persona = i.getPersona();
            EstudiantePersonaOutputDTO estudiantePersonaOutputDTO = new EstudiantePersonaOutputDTO(i, persona);
            listaOutput.add(estudiantePersonaOutputDTO);
        }

        return listaOutput;
    }

    @Override
    public EstudiantePersonaOutputDTO busquedaPorUsuario(String usuario) throws Exception {
        return null;
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
