package com.example.DB2.infrastructure.dto.output;

import com.example.DB2.domain.PersonaDB2;
import com.example.DB2.domain.ProfesorDB2;
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

    private PersonaDB2 persona;

    private List<String> id_estudiante;

    public ProfesorOutputDTO(ProfesorDB2 profesor)
    {
        setId_profesor(profesor.getId_profesor());
        setComentarios(profesor.getComentarios());
        setRama(profesor.getRama());
      /*  setId_estudiante(profesor.getId_estudiante());*/
    }
}
