package com.example.ficheros.infrastructure.dto.output;

import com.example.ficheros.domain.Fichero;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class FicheroOutputDTO implements Serializable {

    private Integer Id;

    private String categoria;
    private String nombre;
    private Date fechaSubida;

    public FicheroOutputDTO(Fichero fichero) {
        setId(fichero.getId());
        setCategoria(fichero.getCategoria());
        setNombre(fichero.getNombre());
        setFechaSubida(fichero.getFechaSubida());
    }
}
