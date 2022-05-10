package com.example.DB2.infrastructure.dto.output;

import com.example.DB2.domain.EstudianteDB2;
import com.example.DB2.domain.ProfesorDB2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteOutputDTO implements Serializable {

    private String id;

    private int numeroHorasSemanales;

    private String rama;

    private String comentarios;

    private ProfesorDB2 profesor;

    public EstudianteOutputDTO(EstudianteDB2 estudiante)
    {
        setId(estudiante.getId());
        setNumeroHorasSemanales(estudiante.getNumeroHorasSemanales());
        setRama(estudiante.getRama());
        setComentarios(estudiante.getComentarios());
        setProfesor(estudiante.getProfesor());
    }
}
