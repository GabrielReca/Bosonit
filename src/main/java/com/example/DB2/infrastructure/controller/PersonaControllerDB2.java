package com.example.DB2.infrastructure.controller;

import com.example.DB2.application.port.EstudianteService;
import com.example.DB2.application.port.ProfesorService;
import com.example.DB2.infrastructure.dto.input.PersonaInputDTO;
import com.example.DB2.infrastructure.dto.output.EstudiantePersonaOutputDTO;
import com.example.DB2.infrastructure.dto.output.PersonaOutputDTO;
import com.example.DB2.application.port.PersonaService;
import com.example.DB2.infrastructure.dto.output.ProfesorOutputDTO;
import com.example.DB2.infrastructure.dto.output.ProfesorPersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DB2/persona")
public class PersonaControllerDB2 {

    @Autowired
    PersonaService ps;

    @Autowired
    EstudianteService es;

    @Autowired
    ProfesorService pfr;

    @GetMapping("/profesor/id/{id}")
    public ProfesorOutputDTO buscarProfesorAsociado(@PathVariable int id) throws Exception {
        ProfesorOutputDTO profesorOutputDTO = ps.buscarProfesor(id);
        return profesorOutputDTO;
    }

    @GetMapping(value = "/busqueda/id/{id}", params = "outputType")
    public ResponseEntity busquedaID(@PathVariable int id, @RequestParam String outputType) throws Exception {
        if(outputType.equals("simple")) {
            PersonaOutputDTO personaOutputDTO;
            try {
                personaOutputDTO = ps.buscarPorID(id);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("usuario puede ser nulo");
            }
            return ResponseEntity.ok(personaOutputDTO);
        } else if (outputType.equals("estudiante")) {
            EstudiantePersonaOutputDTO estudiantePersonaOutputDTO;
            try {
                estudiantePersonaOutputDTO = ps.buscarAlumnoAsociado(id);
            }catch (Exception e){
                return ResponseEntity.badRequest().body("usuario puede ser nulo");
            }
            return ResponseEntity.ok().body(estudiantePersonaOutputDTO);
        }
        else if (outputType.equals("profesor")) {
            ProfesorPersonaOutputDTO profesorPersonaOutputDTO;
            try {
                profesorPersonaOutputDTO = ps.buscarProfesorAsociado(id);
            }catch (Exception e){
                return ResponseEntity.badRequest().body("usuario puede ser nulo");
            }
            return ResponseEntity.ok().body(profesorPersonaOutputDTO);
        }
        return null;
    }

    @GetMapping(value = "/busqueda/todos", params = "outputType")
    public ResponseEntity busquedaTodos(@RequestParam String outputType) throws Exception {
        if(outputType.equals("simple")) {
            List<PersonaOutputDTO> listaOutput = ps.busquedaTodos();
            return ResponseEntity.ok(listaOutput);
        } else if (outputType.equals("estudiante")) {
            List<EstudiantePersonaOutputDTO> lista = es.busquedaTodosFull();
            return ResponseEntity.ok().body(lista);
        } else if (outputType.equals("profesor")) {
            List<ProfesorPersonaOutputDTO> lista = pfr.buscarTodosFull();
            return ResponseEntity.ok().body(lista);
        }
        return null;
    }

    @GetMapping(value = "/busqueda/usuario/{usuario}", params = "outputType")
    public ResponseEntity busquedaUsuario(@PathVariable String usuario, @RequestParam String outputType) throws Exception {

        if(outputType.equals("simple")) {
            PersonaOutputDTO personaOutputDTO;
            try {
                personaOutputDTO = ps.busquedaUsuario(usuario);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("usuario puede ser nulo");
            }
            return ResponseEntity.ok(personaOutputDTO);
        } else if (outputType.equals("estudiante")) {
            EstudiantePersonaOutputDTO estudiantePersonaOutputDTO;
            try {
                estudiantePersonaOutputDTO = ps.buscarAlumnoAsociadoPorUsuario(usuario);
            }catch (Exception e){
                return ResponseEntity.badRequest().body("usuario puede ser nulo");
            }
            return ResponseEntity.ok().body(estudiantePersonaOutputDTO);
        } else if (outputType.equals("profesor")) {
            ProfesorPersonaOutputDTO profesorPersonaOutputDTO;
            try {
                profesorPersonaOutputDTO = ps.buscarProfesorAsociadoporUsuario(usuario);
            }catch (Exception e){
                return ResponseEntity.badRequest().body("usuario puede ser nulo");
            }
            return ResponseEntity.ok().body(profesorPersonaOutputDTO);
        }
        return null;
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity modificarPersona(@PathVariable int id, @RequestBody PersonaInputDTO personaDto) throws Exception
    {
        PersonaOutputDTO personaOutputDTO;
        try {
            personaOutputDTO = ps.modificarPersona(id, personaDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("usuario puede ser nulo");
        }
        return ResponseEntity.ok(personaOutputDTO);
    }

    @PostMapping("/anhadir")
    public ResponseEntity anhadirPersona(@RequestBody PersonaInputDTO personaInputDTO) {
        PersonaOutputDTO personaOutputDTO;
        try {
            personaOutputDTO = ps.anhadirPersona(personaInputDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("usuario puede ser nulo");
        }
        return ResponseEntity.ok(personaOutputDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrarPersona(@PathVariable int id) throws Exception {
        PersonaOutputDTO personaOutputDTO = ps.eliminarUsuario(id);
        return ResponseEntity.ok(personaOutputDTO);
    }
}
