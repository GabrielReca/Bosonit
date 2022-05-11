package com.example.cors.infrastructure.controller;

import com.example.cors.application.port.PersonaService;
import com.example.cors.infrastructure.dto.input.PersonaInputDTO;
import com.example.cors.infrastructure.dto.output.PersonaOutputDTO;
import com.example.cors.infrastructure.errors.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaService ps;

    //@CrossOrigin(origins = "https://cdpn.io")
    @GetMapping("/getall")
    public ResponseEntity busquedaTodos() throws Exception {
        List<PersonaOutputDTO> listaOutput = ps.busquedaTodos();
        return ResponseEntity.ok(listaOutput);
    }


    //@CrossOrigin(origins = "https://cdpn.io")
    @PostMapping("/addperson")
    public ResponseEntity anhadirPersona(@RequestBody PersonaInputDTO personaInputDTO) {
        PersonaOutputDTO personaOutputDTO;
        try {
            personaOutputDTO = ps.anhadirPersona(personaInputDTO);
        } catch (Exception e) {
            throw new UnprocessableException("faltan campos sin insertar");
        }
        return ResponseEntity.ok(personaOutputDTO);
    }
}
