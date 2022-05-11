package com.example.DB1JPA.infrastructure.controller;

import com.example.DB1JPA.application.port.PersonaService;
import com.example.DB1JPA.infrastructure.dto.input.PersonaInputDTO;
import com.example.DB1JPA.infrastructure.dto.output.PersonaOutputDTO;
import com.example.DB1JPA.infrastructure.errors.BeanNotFoundException;
import com.example.DB1JPA.infrastructure.errors.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/DB1/persona")
public class PersonaControllerDB1 {

    @Autowired
    PersonaService ps;

    @GetMapping("/busqueda/id/{id}")
    public ResponseEntity busquedaID(@PathVariable int id) throws Exception {
        PersonaOutputDTO personaOutputDTO;
        try{
            personaOutputDTO = ps.buscarPorID(id);
        }catch (Exception e){
            throw new BeanNotFoundException("bean: " +id+ " no encontrado");
        }
        return ResponseEntity.ok(personaOutputDTO);
    }

    @GetMapping("/busqueda/todos")
    public ResponseEntity busquedaTodos() throws Exception {
        List<PersonaOutputDTO> listaOutput = ps.busquedaTodos();
        return ResponseEntity.ok(listaOutput);
    }

    @GetMapping("/busqueda/usuario/{usuario}")
    public ResponseEntity busquedaTodos(@PathVariable String usuario) throws Exception {
        PersonaOutputDTO personaOutputDTO;
        try{
            personaOutputDTO = ps.busquedaUsuario(usuario);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("usuario puede ser nulo");
        }
        return ResponseEntity.ok(personaOutputDTO);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity modificarPersona(@PathVariable int id, @RequestBody PersonaInputDTO personaDto) throws Exception
    {
        PersonaOutputDTO personaOutputDTO;
        try {
            personaOutputDTO = ps.modificarPersona(id, personaDto);
        } catch (NotFoundException e) {
            throw new BeanNotFoundException("bean: " +id+ " no encontrado");
        }catch (UnprocessableException e)
        {
            throw new UnprocessableException("faltan campos sin insertar");
        }
        return ResponseEntity.ok(personaOutputDTO);
    }

    @PostMapping("/anhadir")
    public ResponseEntity anhadirPersona(@RequestBody PersonaInputDTO personaInputDTO) {
        PersonaOutputDTO personaOutputDTO;
        try {
            personaOutputDTO = ps.anhadirPersona(personaInputDTO);
        } catch (Exception e) {
            throw new UnprocessableException("faltan campos sin insertar");
        }
        return ResponseEntity.ok(personaOutputDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrarPersona(@PathVariable Integer id) throws Exception {
        PersonaOutputDTO personaOutputDTO;
        try {
            personaOutputDTO = ps.eliminarUsuario(id);
        }catch (Exception e)
        {
            throw new BeanNotFoundException("bean: " +id+ " no encontrado");
        }
        return ResponseEntity.ok(personaOutputDTO);
    }
}
