package com.example.BS3CicloDeVidaDeBean;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SegundoService{

    @PostConstruct
    void ejecutable()
    {
        System.out.println("hola desde la segunda clase");
    }
}
