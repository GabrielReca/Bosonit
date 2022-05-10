package com.example.BS4ConfiguracionDeAplicacion.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/valores")
public class ControllerBS4CONF
{
    @Value("${var1}")
    private String var1;

    @Value("${My.var2}")
    private String var2;

    @Value("${VAR_SISTEMA1:Valor_Defecto}")
    private String var3;

    @GetMapping("/var")
    public String leerVariablesProperties()
    {
        return "valor de var1 es: " +var1+ " valor de my.var2 es: " +var2;
    }

    @GetMapping("/var3")
    public String leerVariablesProperties3()
    {
        return "valor de var3 es: " +var3;
    }
}
