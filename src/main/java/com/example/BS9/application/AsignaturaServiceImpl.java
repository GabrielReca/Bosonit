package com.example.BS9.application;

import com.example.BS9.application.port.AsignaturaService;
import com.example.BS9.domain.Estudiante;
import com.example.BS9.domain.Asignatura;
import com.example.BS9.infrastructure.dto.input.AsignaturaInputDTO;
import com.example.BS9.infrastructure.dto.output.AsignaturaOutputDTO;
import com.example.BS9.infrastructure.dto.output.EstudianteAsignaturaOutputDTO;
import com.example.BS9.infrastructure.repository.AsignaturaRepository;
import com.example.BS9.infrastructure.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    AsignaturaRepository ar;

    @Autowired
    EstudianteRepository er;

    @Override
    public EstudianteAsignaturaOutputDTO buscarAsignaturasPorID(String id) {
        Estudiante estudiante = er.findById(id).get();
        EstudianteAsignaturaOutputDTO estudianteAsignaturaOutputDTO = new EstudianteAsignaturaOutputDTO(estudiante);
        return estudianteAsignaturaOutputDTO;
    }

    @Override
    public AsignaturaOutputDTO crearAsignatura(AsignaturaInputDTO estudianteAsignaturaInputDTO) {
        Asignatura estudianteAsignatura = new Asignatura(estudianteAsignaturaInputDTO);
        ar.save(estudianteAsignatura);
        AsignaturaOutputDTO estudianteAsignaturaOutputDTO = new AsignaturaOutputDTO(estudianteAsignatura);
        return estudianteAsignaturaOutputDTO;
    }
}
