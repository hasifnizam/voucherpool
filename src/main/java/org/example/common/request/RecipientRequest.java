package org.example.common.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RecipientRequest {

    @NotBlank(message = "Name must not be null!")
    private String name;

    @NotBlank(message = "Email must not be null")
    @Email(message = "Please insert valid email format")
    private String email;
}
