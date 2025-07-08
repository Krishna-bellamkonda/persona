package com.example.persona.service;

import com.example.persona.dto.UserPersonaRequestDTO;
import com.example.persona.model.UserPersona;
import com.example.persona.repository.UserPersonaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserPersonaService {

    private final UserPersonaRepository userPersonaRepository;

    // Constructor injection for UserPersonaRepository
    public UserPersonaService(UserPersonaRepository userPersonaRepository) {
        this.userPersonaRepository = userPersonaRepository;
    }

    // Additional methods for user persona management can be added here
    public UserPersona findByEmail(String email) {
        return userPersonaRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User persona not found with email: " + email));
    }

    public UserPersona findByUID(String uID) {
        return userPersonaRepository.findByUid(uID)
                .orElseThrow(() -> new RuntimeException("User persona not found with UID: " + uID));
    }

    public UserPersona createPersona(UserPersonaRequestDTO dto) {
        return userPersonaRepository.save(UserPersona.builder()
                .uid(dto.getUid())
                .email(dto.getEmail())
                .name(dto.getName())
                .role(dto.getRole())
                .dob(dto.getDob())
                .gender(dto.getGender())
                .signupDate(dto.getSignupDate())
                .lastLoginDate(dto.getLastLoginDate())
                .phone(dto.getPhone())
                .address1(dto.getAddress1())
                .address2(dto.getAddress2())
                .city(dto.getCity())
                .state(dto.getState())
                .country(dto.getCountry())
                .zip(dto.getZip())
                .build());
    }


    /*
    public UserPersona findByC_ID(Integer C_ID) {
        return userPersonaRepository.findByC_ID(C_ID)
                .orElseThrow(() -> new RuntimeException("User persona not found with C_ID: " + C_ID));
    }
    */
}
