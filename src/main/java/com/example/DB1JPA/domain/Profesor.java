package com.example.DB1JPA.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String id_profesor;

    @Column
    private String comentarios;

    @Column
    private String rama;
/*
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    @MapsId
    private String id_persona;*/

 /*   @OneToMany(mappedBy = "id_profesor", cascade = CascadeType.ALL)
    private List<String> id_estudiante;*/

}
