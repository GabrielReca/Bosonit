package com.example.cors.application.port;


import com.example.cors.infrastructure.dto.input.PersonaInputDTO;
import com.example.cors.infrastructure.dto.output.PersonaOutputDTO;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTO anhadirPersona(PersonaInputDTO personaInputDTO) throws Exception;

    List<PersonaOutputDTO> busquedaTodos();

}
