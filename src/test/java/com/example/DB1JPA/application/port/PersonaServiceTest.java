package com.example.DB1JPA.application.port;

import com.example.DB1JPA.application.PersonaServiceImplDB1;
import com.example.DB1JPA.domain.PersonaDB1;
import com.example.DB1JPA.infrastructure.dto.input.PersonaInputDTO;
import com.example.DB1JPA.infrastructure.repository.PersonaRepositoryDB1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonaServiceTest {

    @Mock
    private PersonaRepositoryDB1 personaRepository;

    @InjectMocks
    private PersonaServiceImplDB1 personaService;

    private PersonaDB1 persona;
    private PersonaInputDTO personaInputDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        personaInputDTO = new PersonaInputDTO();
        personaInputDTO.setId(1);
        personaInputDTO.setUsuario("adsadsad");
        personaInputDTO.setActive(true);
        personaInputDTO.setCity("b");
        personaInputDTO.setCompanyEmail("c");
        personaInputDTO.setPersonalEmail("d");
        personaInputDTO.setName("e");
        personaInputDTO.setSurname("f");
        personaInputDTO.setCreatedDate(java.sql.Date.valueOf("2002-02-02"));
        personaInputDTO.setImagenUrl("g");
        personaInputDTO.setTerminationDate(java.sql.Date.valueOf("2002-02-04"));

        persona = new PersonaDB1(personaInputDTO);
    }

    @Test
    void anhadirPersona() throws ClassNotFoundException {
        when(personaService.anhadirPersona(personaInputDTO)).thenReturn(persona);
        assertNotNull(personaService.anhadirPersona(personaInputDTO));
    }

    @Test
    void modificarPersona() throws ClassNotFoundException {
        when(personaService.modificarPersona(personaInputDTO.getId(),personaInputDTO)).thenReturn(persona);
        assertNotNull(personaService.modificarPersona(personaInputDTO.getId(),personaInputDTO));
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