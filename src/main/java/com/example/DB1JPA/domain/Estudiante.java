package com.example.DB1JPA.domain;

import com.example.DB1JPA.infrastructure.dto.input.EstudianteInputDTO;
import com.example.DB1JPA.utils.StringIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Estudiante")
public class Estudiante implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencias_seq")
    @GenericGenerator(

            name = "ausencias_seq",

            strategy = "com.example.DB1JPA.utils.StringIdGenerator",

            parameters = {

                    @org.hibernate.annotations.Parameter(name = StringIdGenerator.INCREMENT_PARAM, value = "1"),

                    @org.hibernate.annotations.Parameter(name = StringIdGenerator.VALUE_PREFIX_PARAMETER, value = "AUS"),

                    @org.hibernate.annotations.Parameter(name = StringIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")

            })
    private String id;

    @Column(nullable = false)
    private int numeroHorasSemanales;

    @Column(nullable = false)
    private String rama;

    @Column
    private String comentarios;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Persona persona;

  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private String id_profesor;*/

    public Estudiante(EstudianteInputDTO estudianteInputDTO)
    {
        setId(estudianteInputDTO.getId());
        setRama(estudianteInputDTO.getRama());
        setNumeroHorasSemanales(estudianteInputDTO.getNumeroHorasSemanales());
        setComentarios(estudianteInputDTO.getComentarios());
        setPersona(estudianteInputDTO.getPersona());
      /*  setId_profesor(estudianteInputDTO.getId_profesor());*/
    }
}
