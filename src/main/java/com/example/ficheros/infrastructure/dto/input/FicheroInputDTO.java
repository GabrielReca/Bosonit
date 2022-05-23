package com.example.ficheros.infrastructure.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FicheroInputDTO implements Serializable {

    private Integer Id;

    private String categoria;
    private String nombre;
    private Date fechaSubida;

}
