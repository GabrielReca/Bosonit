package com.example.DB2.infrastructure.controller;

import com.example.DB2.application.port.AsignaturaService;
import com.example.DB2.infrastructure.dto.input.AsignaturaInputDTO;
import com.example.DB2.infrastructure.dto.output.AsignaturaOutputDTO;
import com.example.DB2.infrastructure.dto.output.EstudianteAsignaturaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/DB2/asignaturas")
public class AsignaturaControllerDB2 {

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
