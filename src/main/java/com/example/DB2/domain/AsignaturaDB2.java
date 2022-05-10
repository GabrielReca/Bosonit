package com.example.DB2.domain;

import com.example.DB2.infrastructure.dto.input.AsignaturaInputDTO;
import com.example.DB2.utils.StringIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Estudiante_Asignatura")
public class AsignaturaDB2 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DB2")
    @GenericGenerator(

            name = "DB2",

            strategy = "com.example.DB2.utils.StringIdGenerator",

            parameters = {

                    @org.hibernate.annotations.Parameter(name = StringIdGenerator.INCREMENT_PARAM, value = "1"),

                    @org.hibernate.annotations.Parameter(name = StringIdGenerator.VALUE_PREFIX_PARAMETER, value = "ASIG"),

                    @org.hibernate.annotations.Parameter(name = StringIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")

            })
    private String id_asignatura;

    @Column
    private String asignatura;

    @Column
    private String comentarios;

    @Column(nullable = false)
    private Date fecha_inicial;

    @Column
    private Date fecha_final;

/*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private String id_profesor;*/

    public AsignaturaDB2(AsignaturaInputDTO estudianteAsignaturaInputDTO)
    {
        setAsignatura(estudianteAsignaturaInputDTO.getAsignatura());
        setComentarios(estudianteAsignaturaInputDTO.getComentarios());
        setId_asignatura(estudianteAsignaturaInputDTO.getId_asignatura());
        setFecha_final(estudianteAsignaturaInputDTO.getFecha_final());
        setFecha_inicial(estudianteAsignaturaInputDTO.getFecha_inicial());
    }
}
