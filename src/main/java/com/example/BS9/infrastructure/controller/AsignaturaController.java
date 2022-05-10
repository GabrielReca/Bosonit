package com.example.BS9.infrastructure.controller;

import com.example.BS9.application.port.AsignaturaService;
import com.example.BS9.infrastructure.dto.input.AsignaturaInputDTO;
import com.example.BS9.infrastructure.dto.output.AsignaturaOutputDTO;
import com.example.BS9.infrastructure.dto.output.EstudianteAsignaturaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BS9/asignaturas")
public class AsignaturaController {

    @Autowired
    AsignaturaService asignaturaService;

    @PostMapping("/crearAsignaturas")
    public ResponseEntity crearAsignaturas(@RequestBody AsignaturaInputDTO asignaturaInputDTO){
        AsignaturaOutputDTO asignaturaOutputDTO;
        try {
            asignaturaOutputDTO = asignaturaService.crearAsignatura(asignaturaInputDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("mal introducido la asignatura");
        }
        return ResponseEntity.ok(asignaturaOutputDTO);
    }

    @GetMapping("/obtenerAsignaturas/{id}")
    public ResponseEntity buscarAsignaturasPorId(@PathVariable String id){
        EstudianteAsignaturaOutputDTO estudianteAsignaturaOutputDTO;
        try {
            estudianteAsignaturaOutputDTO = asignaturaService.buscarAsignaturasPorID(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("no se han encontrado respuestas");
        }
        return ResponseEntity.ok(estudianteAsignaturaOutputDTO);
    }
}
