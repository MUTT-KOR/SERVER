package com.mutt.mutt_BE.payment.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.global.enums.PaymentMethodType;
import com.mutt.mutt_BE.global.enums.PaymentStatus;
import com.mutt.mutt_BE.global.enums.PgProvider;
import com.mutt.mutt_BE.order.domain.Order;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
/**
 * TODO : 결제 관련 엔티티는 수정 가능성 높음
 * 결제 엔티티
 * 주문에 대한 결제 정보를 관리 (PG사 연동, 결제 금액, 상태 등)
 * PG사 연동하여 실제 결제 처리
 *
 * 관계:
 * - N:1 → Order (주문)
 * - N:1 → Users (결제자)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "payment")
@SuperBuilder
public class Payment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(nullable = false, precision = 11, scale = 2)
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "999999999.99")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PgProvider pgProvider;

    @Column(nullable = false, unique = true)
    private String pgTransactionId;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethodType method;
}
