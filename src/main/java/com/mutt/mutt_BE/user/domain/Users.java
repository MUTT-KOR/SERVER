package com.mutt.mutt_BE.user.domain;

import com.mutt.mutt_BE.common.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password_hash;
    private String nickname;
    private UserRole role;
    private String name;
    private String phoneNumber;
    private LocalDate birthDate;
    private LocalDateTime joined_at;
}
