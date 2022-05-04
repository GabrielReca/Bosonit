package com.example.DB1JPA.infrastructure.dto.output;

import com.example.DB1JPA.domain.Estudiante;
import com.example.DB1JPA.domain.Persona;
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

    private String id_profesor;

    public EstudianteOutputDTO(Estudiante estudiante)
    {
        setId(estudiante.getId());
        setNumeroHorasSemanales(estudiante.getNumeroHorasSemanales());
        setRama(estudiante.getRama());
        setComentarios(estudiante.getComentarios());
/*        setId_profesor(estudiante.getId_profesor());*/
    }
}
