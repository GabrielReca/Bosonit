package com.example.DB2.infrastructure.dto.input;

import com.example.DB2.domain.EstudianteDB2;
import com.example.DB2.domain.ProfesorDB2;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PersonaInputDTO implements Serializable {

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
    private EstudianteDB2 estudiante;
    private ProfesorDB2 profesor;



}
