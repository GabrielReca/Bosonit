package com.example.mongo.infrastructure.controller;

import com.example.mongo.application.port.PersonaService;
import com.example.mongo.infrastructure.dto.input.PersonaInputDTO;
import com.example.mongo.infrastructure.dto.output.PersonaOutputDTO;
import com.example.mongo.infrastructure.errors.BeanNotFoundException;
import com.example.mongo.infrastructure.errors.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo/persona")
public class PersonaControllerMONGO {

    @Autowired
    PersonaService ps;

    @GetMapping("/busqueda/id/{id}")
    public ResponseEntity busquedaID(@PathVariable Integer id) throws Exception {
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
    public ResponseEntity modificarPersona(@PathVariable Integer id, @RequestBody PersonaInputDTO personaDto) throws Exception
    {
        PersonaOutputDTO personaOutputDTO;
        try {
            personaOutputDTO = ps.modificarPersona(id, personaDto);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new BeanNotFoundException("bean: " +id+ " no encontrado");
        }catch (Exception e)
        {
            throw new UnprocessableException("faltan campos sin insertar");
        }
        return ResponseEntity.ok(personaOutputDTO);
    }

    @PostMapping("/anhadir")
    public ResponseEntity anhadirPersona(@RequestBody PersonaInputDTO personaInputDTO) {
        PersonaOutputDTO personaOutputDTO = null;
        try {
            personaOutputDTO = ps.anhadirPersona(personaInputDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(personaOutputDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrarPersona(@PathVariable Integer id) throws Exception {
        PersonaOutputDTO personaOutputDTO = null;
        try {
            personaOutputDTO = ps.eliminarUsuario(id);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return ResponseEntity.ok(personaOutputDTO);
    }
}
