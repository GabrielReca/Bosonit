package com.example.ficheros.domain;

import com.example.ficheros.infrastructure.dto.input.FicheroInputDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "fichero")
public class Fichero implements Serializable
{
    @Id
    private Integer Id;

    @Column(name = "categoria")
    private String categoria;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_subida")
    private Date fechaSubida;

    public Fichero(FicheroInputDTO ficheroInputDTO){
        setId(ficheroInputDTO.getId());
        setCategoria(ficheroInputDTO.getCategoria());
        setNombre(ficheroInputDTO.getNombre());
        setFechaSubida(ficheroInputDTO.getFechaSubida());
    }

}
