package com.example.persona.dto;

import com.example.persona.model.UserPersona;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserPersonaResponseDTO {
    private int c_ID;
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
        this.c_ID = userPersona.getC_ID();
        this.zip = userPersona.getZip();
        this.uID = userPersona.getUID();
        this.state = userPersona.getState();
        this.role = userPersona.getRole();
        this.phone = userPersona.getPhone();
        this.name = userPersona.getName();
    }

}
