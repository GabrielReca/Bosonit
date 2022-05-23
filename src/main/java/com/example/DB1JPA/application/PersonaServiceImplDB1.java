package com.example.DB1JPA.application;

import com.example.DB1JPA.application.port.PersonaServiceDB1;
import com.example.DB1JPA.domain.PersonaDB1;
import com.example.DB1JPA.infrastructure.dto.input.PersonaInputDTO;
import com.example.DB1JPA.infrastructure.errors.LongitudPasada;
import com.example.DB1JPA.infrastructure.repository.PersonaRepositoryDB1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImplDB1 implements PersonaServiceDB1 {

    private static final String USUARIO_NULO = "usuario puede ser nulo";
    private static final String LONGITUD_USUARIO = "longitud del usuario no puede ser superior a 10 caracteres";
    private static final String ID_NO_ENCONTRADO = "id no encontrado";

    @Autowired
    PersonaRepositoryDB1 pr;

    @Override
    public PersonaDB1 anhadirPersona(PersonaInputDTO personaInputDTO) throws ClassNotFoundException {
        if(personaInputDTO.getUsuario() == null)
            throw new ClassNotFoundException(USUARIO_NULO);
        else if(personaInputDTO.getUsuario().length() > 10 || personaInputDTO.getUsuario().length() < 6)
            throw new LongitudPasada((LONGITUD_USUARIO));
        else {
            PersonaDB1 persona = new PersonaDB1(personaInputDTO);
            pr.save(persona);
            return persona;
        }
    }

    @Override
    public PersonaDB1 modificarPersona(int id, PersonaInputDTO personaInputDTO) throws ClassNotFoundException {
        if(personaInputDTO.getUsuario() == null)
            throw new ClassNotFoundException(USUARIO_NULO);
        else if(personaInputDTO.getUsuario().length() > 10 || personaInputDTO.getUsuario().length() < 6)
            throw new LongitudPasada((LONGITUD_USUARIO));
        else {
            pr.deleteById(id);
            PersonaDB1 persona = new PersonaDB1(personaInputDTO);
            pr.save(persona);
            return persona;
        }
    }

    @Override
    public PersonaDB1 buscarPorID(Integer id) throws ClassNotFoundException {
        PersonaDB1 persona = pr.findById(id).orElseThrow(() -> new RuntimeException(ID_NO_ENCONTRADO));
        return persona;
    }

    @Override
    public List<PersonaDB1> busquedaTodos() {
        List<PersonaDB1> lista = (List<PersonaDB1>) pr.findAll();
        return lista;
    }

    @Override
    public PersonaDB1 busquedaUsuario(String usuario) throws ClassNotFoundException {
        if(usuario == null)
            throw new ClassNotFoundException(USUARIO_NULO);
        else if(usuario.length() > 10 || usuario.length() < 6)
            throw new LongitudPasada((LONGITUD_USUARIO));
        else {
            PersonaDB1 persona = pr.buscarPersona(usuario);
            return persona;
        }
    }

    @Override
    public PersonaDB1 eliminarUsuario(Integer id) throws ClassNotFoundException {
        PersonaDB1 persona = pr.findById(id).orElseThrow(() -> new ClassNotFoundException(ID_NO_ENCONTRADO));
        pr.deleteById(id);
        return persona;
    }
}
