package com.example.persona.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;

@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_persona")
public class UserPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(name = "c_uid",unique = true, nullable = false)
    private String uid; //university ID

    @Column(name = "c_role", nullable = false)
    private String role;

    @Column(name = "c_name", nullable = false)
    private String name;

    @Column(name = "c_email", nullable = false)
    private String email;

    @Column(name = "c_phone")
    private String phone;

    @Column(name = "c_address1",nullable = true)
    private String address1;

    @Column(name = "c_address2")
    private String address2;

    @Column(name = "c_city")
    private String city;

    @Column(name = "c_state")
    private String state;

    @Column(name = "c_zip")
    private String zip;

    @Column(name = "c_country")
    private String country;

    @Column(name= "c_dob",nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "c_gender", nullable = false)
    private String gender;

    @Column(name = "c_signup_date", nullable = false)
    private Instant signUpDate;

    @Column(name = "c_last_login_date")
    private Instant lastLoginDate;
}
