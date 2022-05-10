package com.example.BS9.domain;

import com.example.BS9.infrastructure.dto.input.ProfesorInputDTO;
import com.example.BS9.utils.StringIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Profesor")
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BS9")
    @GenericGenerator(

            name = "BS9",

            strategy = "com.example.BS9.utils.StringIdGenerator",

            parameters = {

                    @org.hibernate.annotations.Parameter(name = StringIdGenerator.INCREMENT_PARAM, value = "1"),

                    @org.hibernate.annotations.Parameter(name = StringIdGenerator.VALUE_PREFIX_PARAMETER, value = "PROF"),

                    @org.hibernate.annotations.Parameter(name = StringIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")

            })
    private String id_profesor;

    @Column
    private String comentarios;

    @Column
    private String rama;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona")
    private Persona persona;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.MERGE)
    private List<Estudiante> estudiantes;

    public Profesor(ProfesorInputDTO profesorInputDTO)
    {
        setId_profesor(profesorInputDTO.getId_profesor());
        setComentarios(profesorInputDTO.getComentarios());
        setRama(profesorInputDTO.getRama());
        setPersona(profesorInputDTO.getPersona());
    }

}
