package com.example.JVA2.infrastructure.dto.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public record PersonaInputDTO(int id, String usuario, String password, String name, String surname, String company_email, String personal_email, String city, boolean active, Date created_date, String imagen_url, Date termination_date){


}
