package com.example.DB1JPA.infrastructure.errors;

public class LongitudPasada extends RuntimeException{
    public LongitudPasada(){

    }

    public LongitudPasada(String message){
        super(message);
    }
}
