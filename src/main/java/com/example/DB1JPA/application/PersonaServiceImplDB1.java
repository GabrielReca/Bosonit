package com.example.DB1JPA.application;

import com.example.DB1JPA.application.port.PersonaServiceDB1;
import com.example.DB1JPA.domain.PersonaDB1;
import com.example.DB1JPA.infrastructure.dto.input.PersonaInputDTO;
import com.example.DB1JPA.infrastructure.errors.LongitudPasada;
import com.example.DB1JPA.infrastructure.repository.PersonaRepositoryDB1;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonaServiceImplDB1 implements PersonaServiceDB1 {

  private static final String USUARIO_NULO = "usuario puede ser nulo";
  private static final String LONGITUD_USUARIO = "longitud del usuario no puede ser superior a 10 caracteres";
  private static final String ID_NO_ENCONTRADO = "id no encontrado";

  private final PersonaRepositoryDB1 pr;

  @Override
  public PersonaDB1 anhadirPersona(PersonaInputDTO personaInputDTO) throws ClassNotFoundException {

    PersonaDB1 persona = new PersonaDB1(personaInputDTO);

    return pr.save(persona);

  }

  @Override
  public PersonaDB1 modificarPersona(int id, PersonaInputDTO personaInputDTO) throws ClassNotFoundException {

    pr.deleteById(id);
    PersonaDB1 persona = new PersonaDB1(personaInputDTO);
    pr.save(persona);
    return persona;
  }

}

  @Override
  public PersonaDB1 buscarPorID(Integer id) throws ClassNotFoundException {

    return pr.findById(id).orElseThrow(() -> new ClassNotFoundException(ID_NO_ENCONTRADO));
  }

  @Override
  public List<PersonaDB1> busquedaTodos() {

    return pr.findAll();
  }

  @Override
  public PersonaDB1 busquedaUsuario(String usuario) throws ClassNotFoundException {

    if (usuario.length() > 10 || usuario.length() < 6) {
      throw new LongitudPasada((LONGITUD_USUARIO));
    }

    return pr.buscarPersona(usuario);

  }

  @Override
  public void eliminarUsuario(Integer id) {

    pr.deleteById(id);
  }

}
