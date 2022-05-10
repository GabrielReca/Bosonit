package com.example.BS4.Perfiles.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil1")
public class ServiceImpl1 implements PerfilesService {
    @Value("perfil1")
    private String perfil1;

    @Override
    public void miFuncion() {
        System.out.println("esta funcion tiene el perfil de: " +perfil1);
    }
}
