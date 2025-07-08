package com.example.persona.controller;

import com.example.persona.model.UserPersona;
import com.example.persona.service.UserPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/persona")
@RequiredArgsConstructor
public class UserPersonaController {

    // This controller will handle user persona related requests
    // Add methods to handle user persona operations like creating, updating, deleting personas
    private final UserPersonaService userPersonaService;


    // Constructor injection for UserPersonaService
    /*
    public UserPersonaController(UserPersonaService userPersonaService) {
        this.userPersonaService = userPersonaService;
    }
    */

    @GetMapping("/uid")
    public ResponseEntity<UserPersona> personaOfUID(@RequestParam String uid) {
        return ResponseEntity.ok(userPersonaService.findByUID(uid));
    }

    @GetMapping("/email")
    public ResponseEntity<UserPersona> personaOfEmail(@RequestParam String email) {
        return ResponseEntity.ok(userPersonaService.findByEmail(email));
    }

    @PostMapping("/create")
    public ResponseEntity<UserPersona> createPersona(@RequestBody UserPersona userPersona) {
          userPersonaService.createPersona(userPersona);
          return ResponseEntity.ok(userPersona); //dummy
    }
}
