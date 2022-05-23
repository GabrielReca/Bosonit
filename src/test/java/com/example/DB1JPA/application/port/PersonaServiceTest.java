package com.example.DB1JPA.application.port;

import com.example.DB1JPA.application.PersonaServiceImplDB1;
import com.example.DB1JPA.domain.PersonaDB1;
import com.example.DB1JPA.infrastructure.dto.input.PersonaInputDTO;
import com.example.DB1JPA.infrastructure.dto.output.PersonaOutputDTO;
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

    private PersonaOutputDTO personaOutputDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        personaInputDTO = new PersonaInputDTO();
        personaInputDTO.setId(1);
        personaInputDTO.setUsuario("adsadsad");
        personaInputDTO.setActive(true);
        personaInputDTO.setCity("b");
        personaInputDTO.setCompany_email("c");
        personaInputDTO.setPersonal_email("d");
        personaInputDTO.setName("e");
        personaInputDTO.setSurname("f");
        personaInputDTO.setCreated_date(java.sql.Date.valueOf("2002-02-02"));
        personaInputDTO.setImagen_url("g");
        personaInputDTO.setTermination_date(java.sql.Date.valueOf("2002-02-04"));

        persona = new PersonaDB1(personaInputDTO);
        personaOutputDTO = new PersonaOutputDTO(persona);
    }

    @Test
    void anhadirPersona() throws Exception {
        when(personaService.anhadirPersona(personaInputDTO)).thenReturn(personaOutputDTO);
        assertNotNull(personaService.anhadirPersona(personaInputDTO));
    }

    @Test
    void modificarPersona() throws Exception {
        when(personaService.modificarPersona(personaInputDTO.getId(),personaInputDTO)).thenReturn(personaOutputDTO);
        assertNotNull(personaService.modificarPersona(personaInputDTO.getId(),personaInputDTO));
    }

    @Test
    void buscarPorID() throws Exception {
        when(personaService.buscarPorID(personaInputDTO.getId())).thenReturn(personaOutputDTO);
        assertNotNull(personaService.buscarPorID(personaInputDTO.getId()));
    }

    @Test
    void busquedaTodos() {
        when(personaService.busquedaTodos()).thenReturn(Arrays.asList(personaOutputDTO));
        assertNotNull(personaService.busquedaTodos());
    }

    @Test
    void busquedaUsuario() throws Exception {
        when(personaService.busquedaUsuario(personaInputDTO.getUsuario())).thenReturn(personaOutputDTO);
        assertNotNull(personaService.busquedaUsuario(personaInputDTO.getUsuario()));
    }

    @Test
    void eliminarUsuario() throws Exception {
        System.out.println(personaInputDTO.getId());
        when(personaService.eliminarUsuario(personaInputDTO.getId())).thenReturn(personaOutputDTO);
        assertNotNull(personaService.eliminarUsuario(personaInputDTO.getId()));
    }
}