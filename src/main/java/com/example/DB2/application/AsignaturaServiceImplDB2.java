package com.example.DB2.application;

import com.example.DB2.application.port.AsignaturaService;
import com.example.DB2.domain.EstudianteDB2;
import com.example.DB2.domain.AsignaturaDB2;
import com.example.DB2.infrastructure.dto.input.AsignaturaInputDTO;
import com.example.DB2.infrastructure.dto.output.AsignaturaOutputDTO;
import com.example.DB2.infrastructure.dto.output.EstudianteAsignaturaOutputDTO;
import com.example.DB2.infrastructure.repository.AsignaturaRepositoryDB2;
import com.example.DB2.infrastructure.repository.EstudianteRepositoryDB2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServiceImplDB2 implements AsignaturaService {

    @Autowired
    AsignaturaRepositoryDB2 ar;

    @Autowired
    EstudianteRepositoryDB2 er;

    @Override
    public EstudianteAsignaturaOutputDTO buscarAsignaturasPorID(String id) {
        EstudianteDB2 estudiante = er.findById(id).get();
        EstudianteAsignaturaOutputDTO estudianteAsignaturaOutputDTO = new EstudianteAsignaturaOutputDTO(estudiante);
        return estudianteAsignaturaOutputDTO;
    }

    @Override
    public AsignaturaOutputDTO crearAsignatura(AsignaturaInputDTO estudianteAsignaturaInputDTO) {
        AsignaturaDB2 estudianteAsignatura = new AsignaturaDB2(estudianteAsignaturaInputDTO);
        ar.save(estudianteAsignatura);
        AsignaturaOutputDTO estudianteAsignaturaOutputDTO = new AsignaturaOutputDTO(estudianteAsignatura);
        return estudianteAsignaturaOutputDTO;
    }
}
