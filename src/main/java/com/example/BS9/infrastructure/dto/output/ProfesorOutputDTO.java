package com.example.BS9.infrastructure.dto.output;

import com.example.BS9.domain.Persona;
import com.example.BS9.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorOutputDTO implements Serializable {

    private String id_profesor;

    private String comentarios;

    private String rama;

    private Persona persona;

    private List<String> id_estudiante;

    public ProfesorOutputDTO(Profesor profesor)
    {
        setId_profesor(profesor.getId_profesor());
        setComentarios(profesor.getComentarios());
        setRama(profesor.getRama());
      /*  setId_estudiante(profesor.getId_estudiante());*/
    }
}
