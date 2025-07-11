package com.example.persona.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserPersonaRequestDTO {

    @NotNull
    private String uid;

    @Email
    private String email;
    private String name;
    private String role;
    private LocalDate dateOfBirth;
    private String gender;
    private LocalDateTime signUpDate;
    private LocalDateTime lastLoginDate;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String zip;
}
