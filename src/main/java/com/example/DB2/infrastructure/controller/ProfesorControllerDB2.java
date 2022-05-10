package com.example.DB2.infrastructure.controller;

import com.example.DB2.application.ProfesorServiceImplDB2;
import com.example.DB2.infrastructure.dto.input.ProfesorInputDTO;
import com.example.DB2.infrastructure.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/DB2/profesor")
public class ProfesorControllerDB2 {

    @Autowired
    ProfesorServiceImplDB2 ps;

    @GetMapping(value = "/busqueda/id/{id}")
    public ResponseEntity busquedaID(@PathVariable String id) throws Exception {

        ProfesorOutputDTO profesorOutputDTO;
        try {
            profesorOutputDTO = ps.buscarPorID(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("usuario puede ser nulo");
        }
        return ResponseEntity.ok(profesorOutputDTO);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity modificarProfesor(@PathVariable String  id, @RequestBody ProfesorInputDTO profesorInputDTO) throws Exception
    {
        ProfesorOutputDTO profesorOutputDTO;
        try {
            profesorOutputDTO = ps.modificarProfesor(id, profesorInputDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("usuario puede ser nulo");
        }
        return ResponseEntity.ok(profesorOutputDTO);
    }

    @PostMapping("/anhadir")
    public ResponseEntity anhadirProfesor(@RequestBody ProfesorInputDTO profesorInputDTO) throws Exception {
        ProfesorOutputDTO profesorOutputDTO;
        profesorOutputDTO = ps.anhadirProfesor(profesorInputDTO);
        return ResponseEntity.ok(profesorOutputDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrarProfesor(@PathVariable String  id) throws Exception {
        ProfesorOutputDTO profesorOutputDTO = ps.eliminarProfesor(id);
        return ResponseEntity.ok(profesorOutputDTO);
    }
}
