package com.example.DB1JPA.infrastructure.dto.input;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class ProfesorInputDTO implements Serializable
{
    private String id_profesor;

    private String comentarios;

    private String rama;

    private String id_persona;

    private List<String> id_estudiante;
}
