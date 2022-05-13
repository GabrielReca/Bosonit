package com.example.DBA1.infrastructure.controller;

import com.example.DBA1.application.PersonaServiceImplDBA1;
import com.example.DBA1.domain.PersonaDBA1;
import com.example.DBA1.infrastructure.dto.input.PersonaInputDTO;
import com.example.DBA1.infrastructure.dto.output.PersonaOutputDTO;
import com.example.DBA1.infrastructure.errors.BeanNotFoundException;
import com.example.DBA1.infrastructure.errors.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/DBA1/persona")
public class PersonaControllerDBA1 {

    @Autowired
    PersonaServiceImplDBA1 ps;

    @GetMapping(value = "/get", params = {"dateCondition", "name", "user", "surname"})
    public ResponseEntity queryAvanzada(@RequestParam String dateCondition, @RequestParam (required = false) String name, @RequestParam (required = false) String surname, @RequestParam (required = false) String user) throws Exception {
        HashMap<String, Object> mapa = null;
        List<PersonaDBA1> personas = null;
        try{
            if(!name.equals(null)) {
                mapa.put("name", name);
                mapa.put("dateCondition", dateCondition);
                personas = ps.getData(mapa);
                return ResponseEntity.ok().body(personas);
            }
            else if(!surname.equals(null)) {
                mapa.put("surname", surname);
                mapa.put("dateCondition", dateCondition);
                personas = ps.getData(mapa);
                return ResponseEntity.ok().body(personas);
            }
            if(!user.equals(null)) {
                mapa.put("user", user);
                mapa.put("dateCondition", dateCondition);
                personas = ps.getData(mapa);
                return ResponseEntity.ok().body(personas);
            }
        }catch (Exception e){
            throw new BeanNotFoundException("persona no encontrada");
        }
        return null;
    }

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
        }catch (Exception e)
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
