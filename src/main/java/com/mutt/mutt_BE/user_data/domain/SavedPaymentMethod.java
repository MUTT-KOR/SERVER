package com.mutt.mutt_BE.user_data.domain;

import com.mutt.mutt_BE.common.enums.PaymentMethodType;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class SavedPaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Users user;
    private PaymentMethodType paymentMethodType;
    private String cardMask;
    private Long pgcustomerKey;
    private boolean isDefault;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
