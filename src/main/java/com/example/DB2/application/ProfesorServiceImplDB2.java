package com.example.DB2.application;

import com.example.DB2.application.port.ProfesorService;
import com.example.DB2.domain.PersonaDB2;
import com.example.DB2.domain.ProfesorDB2;
import com.example.DB2.infrastructure.dto.input.ProfesorInputDTO;
import com.example.DB2.infrastructure.dto.output.ProfesorOutputDTO;
import com.example.DB2.infrastructure.dto.output.ProfesorPersonaOutputDTO;
import com.example.DB2.infrastructure.repository.PersonaRepositoryDB2;
import com.example.DB2.infrastructure.repository.ProfesorRepositoryDB2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorServiceImplDB2 implements ProfesorService {

    @Autowired
    ProfesorRepositoryDB2 pfr;

    @Autowired
    PersonaRepositoryDB2 pr;

    @Override
    public ProfesorOutputDTO buscarPorID(String id) throws Exception {
        ProfesorDB2 profesor = pfr.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesor);
        return profesorOutputDTO;
    }

    @Override
    public ProfesorPersonaOutputDTO buscarPorIDFull(String id) throws Exception {
        /*Persona persona = pr.findById(id).get();
        Profesor profesor = persona.getProfesor();
        ProfesorPersonaOutputDTO profesorPersonaOutputDTO = new ProfesorPersonaOutputDTO(profesor, persona);*/
        return null;
    }

    @Override
    public List<ProfesorPersonaOutputDTO> buscarTodosFull() {
        List<ProfesorDB2> listaPro = (List<ProfesorDB2>) pfr.findAll();
        List<ProfesorPersonaOutputDTO> listaOutput = new ArrayList<>();

        for(ProfesorDB2 i: listaPro)
        {
            PersonaDB2 persona = i.getPersona();
            ProfesorPersonaOutputDTO profesorPersonaOutputDTO = new ProfesorPersonaOutputDTO(i, persona);
            listaOutput.add(profesorPersonaOutputDTO);
        }

        return listaOutput;
    }

    @Override
    public ProfesorOutputDTO anhadirProfesor(ProfesorInputDTO profesorInputDTO) throws Exception {
        ProfesorDB2 profesor = new ProfesorDB2(profesorInputDTO);
        pfr.save(profesor);
        ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesor);
        return profesorOutputDTO;
    }

    @Override
    public ProfesorOutputDTO modificarProfesor(String id, ProfesorInputDTO profesorInputDTO) throws Exception {
        if(profesorInputDTO.getId_profesor() == null)
            throw new Exception("usuario puede ser nulo");
        else if(profesorInputDTO.getId_profesor().length() > 10)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            pfr.deleteById(id);
            ProfesorDB2 profesor = new ProfesorDB2(profesorInputDTO);
            pfr.save(profesor);
            ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesor);
            return profesorOutputDTO;
        }
    }

    @Override
    public ProfesorOutputDTO eliminarProfesor(String id) throws Exception {
        ProfesorDB2 profesor = pfr.findById(id).get();
        ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesor);
        pfr.deleteById(id);
        return profesorOutputDTO;
    }
}
