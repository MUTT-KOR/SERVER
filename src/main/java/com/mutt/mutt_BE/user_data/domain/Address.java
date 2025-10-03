package com.mutt.mutt_BE.user_data.domain;

import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private String recipientName;
    private String phoneNumber;
    private String zipCode;
    private String streetAddress;
    private String detailedAddress;
    private boolean isDefault;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



}
