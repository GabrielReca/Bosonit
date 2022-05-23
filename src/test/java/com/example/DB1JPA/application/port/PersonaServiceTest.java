package com.example.DB1JPA.application.port;

import com.example.DB1JPA.application.PersonaServiceImplDB1;
import com.example.DB1JPA.domain.PersonaDB1;
import com.example.DB1JPA.infrastructure.dto.input.PersonaInputDTO;
import com.example.DB1JPA.infrastructure.repository.PersonaRepositoryDB1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class PersonaServiceTest {

  @Mock
  private PersonaRepositoryDB1 personaRepository;

  @Autowired
  private PersonaServiceImplDB1 personaService;

  private PersonaDB1 persona;
  private PersonaInputDTO personaInputDTO;

  @BeforeEach
  void setUp() {

    personaInputDTO = PersonaInputDTO.builder()
        .id(1)
        .usuario("adsadsad")
        .active(true)
        .city("b")
        .companyEmail("c")
        .personalEmail("d")
        .name("e")
        .surname("f")
        .createdDate(java.sql.Date.valueOf("2002-02-02"))
        .imagenUrl("g")
        .terminationDate(java.sql.Date.valueOf("2002-02-04"))
        .build();

    persona = new PersonaDB1(personaInputDTO);
  }

  @Test
  void anhadirPersona() throws ClassNotFoundException {

    when(personaService.anhadirPersona(personaInputDTO)).thenReturn(persona);
    assertNotNull(personaService.anhadirPersona(personaInputDTO));
  }

  @Test
  void modificarPersona() throws ClassNotFoundException {

    when(personaService.modificarPersona(personaInputDTO.getId(), personaInputDTO)).thenReturn(persona);
    assertNotNull(personaService.modificarPersona(personaInputDTO.getId(), personaInputDTO));
  }

  @Test
  void buscarPorID() throws ClassNotFoundException {

    when(personaService.buscarPorID(personaInputDTO.getId())).thenReturn(persona);
    assertNotNull(personaService.buscarPorID(personaInputDTO.getId()));
  }

  @Test
  void busquedaTodos() {

    when(personaService.busquedaTodos()).thenReturn(Arrays.asList(persona));
    assertNotNull(personaService.busquedaTodos());
  }

  @Test
  void busquedaUsuario() throws ClassNotFoundException {

    when(personaService.busquedaUsuario(personaInputDTO.getUsuario())).thenReturn(persona);
    assertNotNull(personaService.busquedaUsuario(personaInputDTO.getUsuario()));
  }

  @Test
  void eliminarUsuario() throws ClassNotFoundException {

    System.out.println(personaInputDTO.getId());
    when(personaService.eliminarUsuario(personaInputDTO.getId())).thenReturn(persona);
    assertNotNull(personaService.eliminarUsuario(personaInputDTO.getId()));
  }

}