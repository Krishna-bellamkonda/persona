package com.example.persona.repository;

import com.example.persona.model.UserPersona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPersonaRepository extends JpaRepository<UserPersona, Long> {
    Optional<UserPersona> findByEmail(String email);
    Optional<UserPersona> findByUid(String uID);
    Optional<UserPersona> findByCid(Long cid);
}
