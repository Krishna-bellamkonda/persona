package com.example.persona.repository;

import com.example.persona.model.UserPersona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPersonaRepository extends JpaRepository<UserPersona, Integer> {
    Optional<UserPersona> findByEmail(String email);
    Optional<UserPersona> findByUID(String UID);
    Optional<UserPersona> findByC_ID(Integer C_ID);
}
