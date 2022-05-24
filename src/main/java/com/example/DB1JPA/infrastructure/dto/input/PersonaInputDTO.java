package com.example.DB1JPA.infrastructure.dto.input;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaInputDTO implements Serializable {

  private Integer id;

  @NotNull(message = "usuario puede ser nulo")
  @Size(min = 6, max = 10, message = "longitud del usuario no puede ser superior a 10 caracteres")
  private String usuario;
  private String password;
  private String name;
  private String surname;
  private String companyEmail;
  private String personalEmail;
  private String city;
  private boolean active;
  private Date createdDate;
  private String imagenUrl;
  private Date terminationDate;


}
