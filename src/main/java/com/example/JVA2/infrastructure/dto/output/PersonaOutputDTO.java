package com.example.JVA2.infrastructure.dto.output;

import java.util.Date;

public record PersonaOutputDTO(int id, String usuario, String password, String name, String surname, String company_email, String personal_email, String city, boolean active, Date created_date, String imagen_url, Date termination_date){


}
