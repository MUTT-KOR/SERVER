package com.mutt.mutt_BE.finance.domain;

import com.mutt.mutt_BE.common.enums.SettlementStatus;
import com.mutt.mutt_BE.order.domain.OrderItem;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Settlement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Users user;
    private OrderItem orderItem;
    private Long totalRevenue;
    private Integer commissionRate;
    private Double netAmount;
    private LocalDateTime createdAt;
    private LocalDateTime settlementAt;
    private SettlementStatus status;
}
