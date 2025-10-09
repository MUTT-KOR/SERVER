package com.mutt.mutt_BE.payment.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.common.enums.PaymentMethodType;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import lombok.*;

/**
 * TODO : 결제 관련 엔티티는 수정 가능성 높음
 * 저장된 결제 수단 엔티티
 * 사용자가 저장한 결제 수단 정보를 관리 (카드, 계좌 등)
 * PG사의 고객 키를 통해 간편 결제 지원
 *
 * 보안: 카드번호는 마스킹 처리하여 저장
 */

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class SavedPaymentMethod extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private Users user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethodType paymentMethodType;

    @Column(nullable = false,unique = true)
    private String cardMask;

    @Column(nullable = false,unique = true)
    private String pgCustomerKey;

    @Column(nullable = false)
    private boolean isDefault;

}
