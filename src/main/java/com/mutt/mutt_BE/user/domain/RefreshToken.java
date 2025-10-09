package com.mutt.mutt_BE.user.domain;

import com.mutt.mutt_BE.common.enums.TokenType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
/**
 * JWT 인증에서 Access Token 재발급을 위한 Refresh Token을 관리
 * 만료 시간을 추적하여 자동 로그아웃 처리
 *
 * 관계:
 * - N:1 → Users (토큰 소유자)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(nullable = false)
    private String tokenContent;

    @Column(nullable = false)
    private TokenType tokenType;

    @Column(nullable = false)
    private LocalDateTime expiryAt;


}
