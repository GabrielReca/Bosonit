package com.example.BS3CicloDeVidaDeBean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TercerService implements CommandLineRunner {

    //Segunda parte
    @Override
    public void run(String... args) throws Exception {
        System.out.println("servicio iniciado con interfaz commandLineRunner. Parametros: ");
    }
/*  primera parte
    @PostConstruct
    void ejecutable()
    {
        System.out.println("hola desde la tercera clase");
    }*/
}
