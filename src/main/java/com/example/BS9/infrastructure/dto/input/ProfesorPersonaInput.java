package com.example.BS9.infrastructure.dto.input;

import com.example.BS9.domain.Persona;

import java.io.Serializable;
import java.util.Date;

public class ProfesorPersonaInput implements Serializable {

    private String id_profesor;
    private String comentarios;
    private String rama;
    private Persona persona;

    private int id;
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
