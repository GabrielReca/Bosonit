package com.example.DB1JPA.infrastructure.dto.output;

import com.example.DB1JPA.domain.PersonaDB1;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaOutputDTO implements Serializable {

    private int id;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private boolean active;
    private Date createdDate;
    private String imagenUrl;
    private Date terminationDate;

    public PersonaOutputDTO(PersonaDB1 persona)
    {
        setId(persona.getId());
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompanyEmail(persona.getCompanyEmail());
        setPersonalEmail(persona.getPersonalEmail());
        setCity(persona.getCity());
        setActive(persona.isActive());
        setCreatedDate(persona.getCreatedDate());
        setImagenUrl(persona.getImagenUrl());
        setTerminationDate(persona.getTerminationDate());
    }
}
