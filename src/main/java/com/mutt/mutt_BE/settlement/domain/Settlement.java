package com.mutt.mutt_BE.settlement.domain;

import com.mutt.mutt_BE.common.enums.SettlementStatus;
import com.mutt.mutt_BE.product.domain.Product;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 정산 엔티티
 * 판매자에게 지급할 월별 정산 내역을 관리
 * 매출, 수수료, 실 정산금액을 계산하여 보관
 *
 * TODO : 계산식 짜기
 * 계산식: netAmount = totalRevenue × (1 - commissionRate / 100)
 *
 * 관계:
 * - N:1 → Users (판매자)
 * - N:1 → Product (정산 대상 상품)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Settlement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product", nullable = false)
    private Product product;

    @Column(nullable = false)
    @Min(0)
    private Integer orderCount;

    // 총 매출액 최대 : 999만원
    @Column(nullable = false,precision = 9, scale = 2)
    @DecimalMin(value = "0.00")
    @DecimalMax(value = "9999999.99")
    private BigDecimal totalRevenue;

    // 수수료 :
    @Column(nullable = false,precision = 5, scale = 2)
    @DecimalMin(value = "0.00")
    @DecimalMax(value = "100.00")
    private BigDecimal commissionRate;

    @Column(nullable = false,precision = 9, scale = 2)
    @DecimalMin(value = "0.00")
    @DecimalMax(value = "9999999.99")
    private BigDecimal netAmount;

    // 2025-03
    @Column(nullable = false, length = 7)
    private String settlementMonth;

    @Column(nullable = false)
    private LocalDateTime paidAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SettlementStatus status;
}
