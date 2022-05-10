package com.example.DB2.application;

import com.example.DB2.application.port.EstudianteService;
import com.example.DB2.domain.EstudianteDB2;
import com.example.DB2.domain.PersonaDB2;
import com.example.DB2.infrastructure.dto.input.EstudianteInputDTO;
import com.example.DB2.infrastructure.dto.output.EstudianteOutputDTO;
import com.example.DB2.infrastructure.dto.output.EstudiantePersonaOutputDTO;
import com.example.DB2.infrastructure.repository.EstudianteRepositoryDB2;
import com.example.DB2.infrastructure.repository.PersonaRepositoryDB2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteServiceImplDB2 implements EstudianteService {

    @Autowired
    EstudianteRepositoryDB2 er;

    @Autowired
    PersonaRepositoryDB2 pr;

    @Override
    public EstudianteOutputDTO buscarPorID(String id) throws Exception {
        EstudianteDB2 estudiante = er.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        EstudianteOutputDTO estudianteOutputDTO = new EstudianteOutputDTO(estudiante);
        return estudianteOutputDTO;
    }

    @Override
    public EstudiantePersonaOutputDTO buscarPorIDFull(String id) throws Exception {
        EstudianteDB2 estudiante = er.findById(id).get();
        PersonaDB2 persona = estudiante.getPersona();
        EstudiantePersonaOutputDTO estudiantePersonaOutputDTO = new EstudiantePersonaOutputDTO(estudiante, persona);
        return estudiantePersonaOutputDTO;
    }

    @Override
    public List<EstudiantePersonaOutputDTO> busquedaTodosFull() throws Exception {
        List<EstudianteDB2> listaEst = (List<EstudianteDB2>) er.findAll();
        List<EstudiantePersonaOutputDTO> listaOutput = new ArrayList<>();

        for(EstudianteDB2 i: listaEst)
        {
            PersonaDB2 persona = i.getPersona();
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
            EstudianteDB2 estudiante = new EstudianteDB2(estudianteInputDTO);
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
            EstudianteDB2 estudiante = new EstudianteDB2(estudianteInputDTO);
            er.save(estudiante);
            EstudianteOutputDTO estudianteOutputDTO = new EstudianteOutputDTO(estudiante);
            return estudianteOutputDTO;
        }
    }

    @Override
    public EstudianteOutputDTO eliminarUsuario(String id) throws Exception {
        EstudianteDB2 estudiante = er.findById(id).get();
        EstudianteOutputDTO estudianteOutputDTO = new EstudianteOutputDTO(estudiante);
        er.deleteById(id);
        return estudianteOutputDTO;
    }
}
