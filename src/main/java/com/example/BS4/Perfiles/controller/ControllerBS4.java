package com.example.BS4.Perfiles.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBS4 {

    @Value("${url}")
    private String url;

    @Value("${contra}")
    private String password;

    @Value("${valor1}")
    private String valor1;

    @Value("${valor2}")
    private String valor2;

    @GetMapping("/parametros")
    public String obtenerParam()
    {
        return url + " - " + password;
    }

    @GetMapping("/miconfiguracion")
    public String miconfiguracion()
    {
        return valor1 + " - " + valor2;
    }

    @GetMapping("/perfil")
    public String perfil()
    {
        return valor1 + " - " + valor2;
    }
}
