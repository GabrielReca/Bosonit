package com.example.DB1JPA.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Estudiante_Asignatura")
public class EstudianteAsignatura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_asignatura;

    @Column
    private String asignatura;

    @Column
    private String comentarios;

    @Column(nullable = false)
    private Date fecha_inicial;

    @Column
    private Date fecha_final;

 /*   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante")
    private String id_estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private String id_profesor;*/
}
