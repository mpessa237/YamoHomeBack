package com.example.YamoHome.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    @NotEmpty(message = "nom is mandatory")
    @NotBlank(message = "nom is mandatory")
    private String nom;
    @NotEmpty(message = "email is mandatory")
    @NotBlank(message = "email is mandatory")
    @Email(message = "Email not well formatted")
    private String email;
    @NotEmpty(message = "motDePasse is mandatory")
    @NotBlank(message = "motDePasse is mandatory")
    @Length(min = 6,max = 8, message = "Password must contain at least 6 characters.")
    private String motDePasse;
}
