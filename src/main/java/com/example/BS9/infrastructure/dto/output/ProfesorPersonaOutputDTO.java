package com.example.BS9.infrastructure.dto.output;

import com.example.BS9.domain.Persona;
import com.example.BS9.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorPersonaOutputDTO implements Serializable {

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

    public ProfesorPersonaOutputDTO(Profesor profesor, Persona persona)
    {
        setId_profesor(profesor.getId_profesor());
        setComentarios(profesor.getComentarios());
        setRama(profesor.getRama());
        /*setId_profesor(estudiante.getId_profesor());*/

        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.isActive());
        setCreated_date(persona.getCreated_date());
        setImagen_url(persona.getImagen_url());
        setTermination_date(persona.getTermination_date());
    }
}
