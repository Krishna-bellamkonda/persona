package com.example.persona.service;

import com.example.persona.model.UserPersona;
import com.example.persona.repository.UserPersonaRepository;
import com.example.persona.exception.UserPersonaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .orElseThrow(() -> new UserPersonaNotFoundException("User persona not found with email: " + email));
    }

    public UserPersona findByUID(String UID) {
        return userPersonaRepository.findByUID(UID)
                .orElseThrow(() -> new UserPersonaNotFoundException("User persona not found with UID: " + UID));
    }

    /*
    public UserPersona findByC_ID(String C_ID) {
        return userPersonaRepository.findByC_ID(C_ID)
                .orElseThrow(() -> new UserPersonaNotFoundException("User persona not found with C_ID: " + C_ID));
    }
    */
}
