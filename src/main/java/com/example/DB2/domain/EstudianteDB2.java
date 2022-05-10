package com.example.DB2.domain;

import com.example.DB2.infrastructure.dto.input.EstudianteInputDTO;
import com.example.DB2.utils.StringIdGenerator;
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
@Table(name = "Estudiante")
public class EstudianteDB2 implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DB2")
    @GenericGenerator(

            name = "DB2",

            strategy = "com.example.DB2.utils.StringIdGenerator",

            parameters = {

                    @org.hibernate.annotations.Parameter(name = StringIdGenerator.INCREMENT_PARAM, value = "1"),

                    @org.hibernate.annotations.Parameter(name = StringIdGenerator.VALUE_PREFIX_PARAMETER, value = "ALUM"),

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
    @JoinColumn(name = "persona")
    private PersonaDB2 persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor")
    private ProfesorDB2 profesor;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "asignaturas", joinColumns = @JoinColumn(name = "id_estudiante"), inverseJoinColumns = @JoinColumn(name = "id_asignatura"))
    private List<AsignaturaDB2> asignaturas;

    public EstudianteDB2(EstudianteInputDTO estudianteInputDTO)
    {
        setId(estudianteInputDTO.getId());
        setRama(estudianteInputDTO.getRama());
        setNumeroHorasSemanales(estudianteInputDTO.getNumeroHorasSemanales());
        setComentarios(estudianteInputDTO.getComentarios());
        setPersona(estudianteInputDTO.getPersona());
        setProfesor(estudianteInputDTO.getProfesor());
        setAsignaturas(estudianteInputDTO.getAsignaturas());
    }
}
