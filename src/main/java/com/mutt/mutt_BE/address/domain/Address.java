package com.mutt.mutt_BE.address.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 배송지 엔티티
 * 사용자의 배송지 정보를 관리
 * 사용자는 여러 배송지를 등록 가능, 하나를 기본 배송지로 설정 가능
 *
 * 관계:
 * - N:1 → Users (배송지 소유자)
 * - 1:N ← Order (주문에서 참조)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "address")
@SuperBuilder
public class Address extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private Users user;

    @Column(nullable = false)
    private String recipientName;

    @Column(nullable = false,unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private boolean isDefault;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String streetAddress;

    private String detailedAddress;
}
