package com.example.persona.dto;

import com.example.persona.model.UserPersona;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserPersonaResponseDTO {
    private Long c_ID;
    private String zip;
    private String uID; //university ID
    private String state;
    private String role;
    private String phone;
    private String name;
    private String gender;
    private String email;
    private String country;
    private String city;
    private String address2;
    private String address1;
    private LocalDate dateOfBirth;
    private Instant signUpDate;
    private Instant lastLoginDate;

    public UserPersonaResponseDTO(UserPersona userPersona) {
        this.c_ID = userPersona.getCid();
        this.zip = userPersona.getZip();
        this.uID = userPersona.getUid();
        this.state = userPersona.getState();
        this.role = userPersona.getRole();
        this.phone = userPersona.getPhone();
        this.name = userPersona.getName();
    }

}
