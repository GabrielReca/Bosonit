package com.example.DB1JPA.domain;

import com.example.DB1JPA.infrastructure.dto.input.PersonaInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "persona", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class PersonaDB1 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "usuario")
    private String usuario;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "company_email")
    private String companyEmail;
    @Column(name = "personal_email")
    private String personalEmail;
    @Column(name = "city")
    private String city;
    @Column(name = "active")
    private boolean active;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "imagen_url")
    private String imagenUrl;
    @Column(name = "termination_date")
    private Date terminationDate;

    public PersonaDB1(PersonaInputDTO personaDTO)
    {
        setUsuario(personaDTO.getUsuario());
        setPassword(personaDTO.getPassword());
        setName(personaDTO.getName());
        setSurname(personaDTO.getSurname());
        setCompanyEmail(personaDTO.getCompanyEmail());
        setPersonalEmail(personaDTO.getPersonalEmail());
        setCity(personaDTO.getCity());
        setActive(personaDTO.isActive());
        setCreatedDate(personaDTO.getCreatedDate());
        setImagenUrl(personaDTO.getImagenUrl());
        setTerminationDate(personaDTO.getTerminationDate());
    }
}
