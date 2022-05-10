package com.example.BS10.HolaMundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/a")
    public String hola()
    {
        return "hola mundo";
    }

}
