package com.mutt.mutt_BE.shipping.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.global.enums.ShippingStatus;
import com.mutt.mutt_BE.order.domain.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/**
 * 배송
 * 주문의 배송 상태를 관리 (운송장 번호, 배송 상태, 배송 일시 등)
 * 택배사 API 연동을 통해 실시간 배송 추적 가능
 *
 * 관계:
 * - 1:1 → Order (배송 대상 주문)
 */
@Entity
@Table(name = "shipping")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Shipping extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    @Column(nullable = false,unique = true)
    private String trackingNumber;

    @Column(nullable = false)
    private String carrier;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShippingStatus status;


    private String request;
    private LocalDateTime shippedAt;
    private LocalDateTime deliveredAt;
}
