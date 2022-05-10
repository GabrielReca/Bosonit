package com.example.DB2.infrastructure.dto.input;

import java.io.Serializable;
import java.util.Date;

public class EstudiantePersonaInputDTO implements Serializable {

    private String id;
    private int numeroHorasSemanales;
    private String rama;
    private String comentarios;
    private String id_profesor;

    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;
}
