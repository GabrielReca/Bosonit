package com.example.DB2.infrastructure.dto.input;

import com.example.DB2.domain.PersonaDB2;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ProfesorInputDTO implements Serializable
{
    private String id_profesor;

    private String comentarios;

    private String rama;

    private PersonaDB2 persona;

    /*private List<String> id_estudiante;*/
}
