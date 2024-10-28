package dev.jpmachado.crud_springboot.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class ClientDto implements Serializable {

    private Integer id;

    @Size(min = 3, max = 45, message = "First name must be between 3 and 50 characters")
    private String firstName;

    @Size(min = 3, max = 45, message = "Last name must be between 3 and 50 characters")
    private String lastName;

    @NotEmpty(message = "Email must not be empty")
    @Size(min = 3, max = 45, message = "Email must be between 3 and 50 characters")
    @Email(message = "Email must be a valid email address")
    private String email;

    private Date createdAt;
}
