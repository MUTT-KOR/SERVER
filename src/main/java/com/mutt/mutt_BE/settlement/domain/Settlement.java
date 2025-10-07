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

/*수정 더 해야함. */
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
    @Builder.Default
    private Integer orderCount=0;

    // 총 매출액 (최대 999,999,999.99원)
    @Column(nullable = false,precision = 11, scale = 2)
    @DecimalMin(value = "0.00")
    @DecimalMax(value = "9999999999.99")
    private BigDecimal totalRevenue;

    // 수수료 :
    @Column(nullable = false,precision = 5, scale = 2)
    @DecimalMin(value = "0.00")
    @DecimalMax(value = "100.00")
    private BigDecimal commissionRate;

    @Column(nullable = false,precision = 11, scale = 2)
    @DecimalMin(value = "0.00")
    @DecimalMax(value = "9999999999.99")
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
