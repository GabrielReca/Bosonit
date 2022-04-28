package com.example.DB1JPA.controller;

import com.example.DB1JPA.clases.Persona;
import com.example.DB1JPA.infrastructure.PersonaInputDTO;
import com.example.DB1JPA.infrastructure.PersonaOutputDTO;
import com.example.DB1JPA.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaService ps;

    @GetMapping("/busqueda/id/{id}")
    public Persona busquedaID(@PathVariable int id) throws Exception {
        return ps.buscarPorID(id);
    }

    @GetMapping("/busqueda/todos")
    public List<Persona> busquedaTodos() throws Exception {
        return ps.busquedaTodos();
    }

    @GetMapping("/busqueda/usuario/{usuario}")
    public Persona busquedaTodos(@PathVariable String usuario) throws Exception {
        return ps.busquedaUsuario(usuario);
    }

    @PutMapping("/modificar/{id}")
    public void modificarPersona(@PathVariable int id, @RequestBody PersonaInputDTO personaDto) throws Exception
    {
        ps.modificarPersona(id, personaDto);
    }

    @PostMapping("/anhadir")
    public void anhadirPersona(@RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        ps.anhadirPersona(personaInputDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarPersona(@PathVariable Integer id) throws Exception {
        ps.eliminarUsuario(id);
    }
}
