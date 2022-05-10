package com.example.BS9.infrastructure.dto.output;

import com.example.BS9.domain.Estudiante;
import com.example.BS9.domain.Profesor;
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

    private Profesor profesor;

    public EstudianteOutputDTO(Estudiante estudiante)
    {
        setId(estudiante.getId());
        setNumeroHorasSemanales(estudiante.getNumeroHorasSemanales());
        setRama(estudiante.getRama());
        setComentarios(estudiante.getComentarios());
        setProfesor(estudiante.getProfesor());
    }
}
