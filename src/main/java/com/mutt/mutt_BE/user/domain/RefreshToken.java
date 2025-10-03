package com.mutt.mutt_BE.user.domain;

import com.mutt.mutt_BE.common.enums.TokenType;
import jakarta.persistence.*;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

import java.time.LocalDateTime;

@Entity
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private String tokenContent;
    private TokenType tokenType;
    private LocalDateTime expiryAt;


}
