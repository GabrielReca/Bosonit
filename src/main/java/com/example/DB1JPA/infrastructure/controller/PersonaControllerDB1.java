package com.example.DB1JPA.infrastructure.controller;

import com.example.DB1JPA.application.port.PersonaServiceDB1;
import com.example.DB1JPA.domain.PersonaDB1;
import com.example.DB1JPA.infrastructure.dto.input.PersonaInputDTO;
import com.example.DB1JPA.infrastructure.dto.output.PersonaOutputDTO;
import com.example.DB1JPA.infrastructure.errors.BeanNotFoundException;
import com.example.DB1JPA.infrastructure.errors.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/DB1/persona")
public class PersonaControllerDB1 {

    @Autowired
    PersonaServiceDB1 ps;

    private static final String BEAN_NO_ENCONTRADO = "bean no encontrado";

    @GetMapping("/busqueda/id/{id}")
    public ResponseEntity<PersonaOutputDTO> busquedaID(@PathVariable int id){
        PersonaDB1 persona;
        try{
            persona = ps.buscarPorID(id);
        }catch (Exception e){
            throw new BeanNotFoundException(BEAN_NO_ENCONTRADO);
        }
        return ResponseEntity.ok(new PersonaOutputDTO(persona));
    }

    @GetMapping("/busqueda/todos")
    public ResponseEntity<List<PersonaOutputDTO>> busquedaTodos() throws ClassNotFoundException {
        List<PersonaDB1> lista = ps.busquedaTodos();
        List<PersonaOutputDTO> listaOutput = new ArrayList<>();
        for(PersonaDB1 i: lista){
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(i);
            listaOutput.add(personaOutputDTO);
        }
        return ResponseEntity.ok(listaOutput);
    }

    @GetMapping("/busqueda/usuario/{usuario}")
    public ResponseEntity<PersonaOutputDTO> busquedaTodos(@PathVariable String usuario){
        PersonaDB1 persona;
        try{
            persona = ps.busquedaUsuario(usuario);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(new PersonaOutputDTO(persona));
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<PersonaOutputDTO> modificarPersona(@PathVariable int id, @RequestBody PersonaInputDTO personaDto)
    {
        PersonaDB1 persona;
        try {
            persona = ps.modificarPersona(id, personaDto);
        } catch (Exception e)
        {
            throw new UnprocessableException("faltan campos sin insertar");
        }
        return ResponseEntity.ok(new PersonaOutputDTO(persona));
    }

    @PostMapping("/anhadir")
    public ResponseEntity<PersonaOutputDTO> anhadirPersona(@RequestBody PersonaInputDTO personaInputDTO) {
        PersonaDB1 persona;
        try {
            persona = ps.anhadirPersona(personaInputDTO);
        } catch (Exception e) {
            throw new UnprocessableException("faltan campos sin insertar");
        }
        return ResponseEntity.ok(new PersonaOutputDTO(persona));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<PersonaOutputDTO> borrarPersona(@PathVariable Integer id){
        PersonaDB1 persona;
        try {
            persona = ps.eliminarUsuario(id);
        }catch (Exception e)
        {
            throw new BeanNotFoundException(BEAN_NO_ENCONTRADO);
        }
        return ResponseEntity.ok(new PersonaOutputDTO(persona));
    }
}
