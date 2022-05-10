package com.example.BS4.Perfiles.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil2")
public class ServiceImpl2 implements PerfilesService {

    @Value("perfil2")
    private String perfil2;

    @Override
    public void miFuncion() {
        System.out.println("esta funcion tiene el perfil de: " +perfil2);
    }
}
