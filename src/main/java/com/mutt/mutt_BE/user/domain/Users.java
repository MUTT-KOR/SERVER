package com.mutt.mutt_BE.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 일반 사용자 엔티티
 * 주문, 장바구니, 리뷰, 위시리스트 등과 연관
 *
 * 탈퇴 관련 필드 :
 * isActive = false , withdrawalAt ,withdrawal_reason
 *
 * @see Account
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "users")
@SuperBuilder
public class Users extends Account {

    @Column(unique = true, length = 20)
    private String phoneNumber;

    private String name;
    private LocalDate birthDate;

    @Column(nullable = false)
    private boolean isActive;
    private LocalDateTime withdrawalAt;
    private String withdrawal_reason;
}
