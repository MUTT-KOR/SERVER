package com.mutt.mutt_BE.interation.domain;

import com.mutt.mutt_BE.product.domain.Product;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class QnA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Product product;
    private Users user;
    private String question;
    private String answer;
    private boolean isAnswered;
    private LocalDateTime questionedAt;
    private LocalDateTime answeredAt;
}
