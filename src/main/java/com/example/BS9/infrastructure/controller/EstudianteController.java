package com.example.BS9.infrastructure.controller;

import com.example.BS9.application.EstudianteServiceImpl;
import com.example.BS9.infrastructure.dto.input.EstudianteInputDTO;
import com.example.BS9.infrastructure.dto.output.EstudianteOutputDTO;
import com.example.BS9.infrastructure.dto.output.EstudiantePersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BS9/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteServiceImpl es;

    @GetMapping(value = "/busqueda/id/{id}", params = "outputType")
    public ResponseEntity busquedaID(@PathVariable String id, @RequestParam (defaultValue = "simple") String outputType) throws Exception {

        if(outputType.equals("simple")) {
            EstudianteOutputDTO estudianteOutputDTO;
            try {
                estudianteOutputDTO = es.buscarPorID(id);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("usuario puede ser nulo");
            }
            return ResponseEntity.ok(estudianteOutputDTO);
        }
        else if (outputType.equals("full")){
            EstudiantePersonaOutputDTO estudiantePersonaOutputDTO;
            try {
                estudiantePersonaOutputDTO = es.buscarPorIDFull(id);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("usuario puede ser nulo");
            }
            return ResponseEntity.ok(estudiantePersonaOutputDTO);
        }
        return null;
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity modificarEstudiante(@PathVariable String  id, @RequestBody EstudianteInputDTO estudianteInputDTO) throws Exception
    {
        EstudianteOutputDTO estudianteOutputDTO;
        try {
            estudianteOutputDTO = es.modificarEstudiante(id, estudianteInputDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("usuario puede ser nulo");
        }
        return ResponseEntity.ok(estudianteOutputDTO);
    }

    @PostMapping("/anhadir")
    public ResponseEntity anhadirPersona(@RequestBody EstudianteInputDTO estudianteInputDTO) {
        EstudianteOutputDTO estudianteOutputDTO;
        estudianteOutputDTO = es.anhadirEstudiante(estudianteInputDTO);
        return ResponseEntity.ok(estudianteOutputDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrarPersona(@PathVariable String  id) throws Exception {
        EstudianteOutputDTO estudianteOutputDTO = es.eliminarUsuario(id);
        return ResponseEntity.ok(estudianteOutputDTO);
    }
}
