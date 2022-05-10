package com.example.DB2.infrastructure.dto.output;

import com.example.DB2.domain.EstudianteDB2;
import com.example.DB2.domain.PersonaDB2;
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
public class EstudiantePersonaOutputDTO implements Serializable {

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

    public EstudiantePersonaOutputDTO(EstudianteDB2 estudiante, PersonaDB2 persona)
    {
        setId(estudiante.getId());
        setNumeroHorasSemanales(estudiante.getNumeroHorasSemanales());
        setRama(estudiante.getRama());
        setComentarios(estudiante.getComentarios());
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
