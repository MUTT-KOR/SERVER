package com.mutt.mutt_BE.user.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class SocialAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users user;

    private String provider;
    private Long providerUserId;
    private LocalDateTime createdAt;
}
