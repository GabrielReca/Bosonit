package com.example.JVA2.domain;

import com.example.JVA2.infrastructure.dto.input.PersonaInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "persona", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class PersonaJVA2 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String usuario;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String company_email;
    @Column
    private String personal_email;
    @Column
    private String city;
    @Column
    private boolean active;
    @Column
    private Date created_date;
    @Column
    private String imagen_url;
    @Column
    private Date termination_date;

    public PersonaJVA2(PersonaInputDTO personaDTO)
    {
        setUsuario(personaDTO.usuario());
        setPassword(personaDTO.password());
        setName(personaDTO.name());
        setSurname(personaDTO.surname());
        setCompany_email(personaDTO.company_email());
        setPersonal_email(personaDTO.personal_email());
        setCity(personaDTO.city());
        setActive(personaDTO.active());
        setCreated_date(personaDTO.created_date());
        setImagen_url(personaDTO.imagen_url());
        setTermination_date(personaDTO.termination_date());
    }
}
