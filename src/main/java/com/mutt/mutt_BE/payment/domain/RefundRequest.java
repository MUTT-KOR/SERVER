package com.mutt.mutt_BE.payment.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.common.enums.TransactionStatus;
import com.mutt.mutt_BE.order.domain.OrderItem;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;

@Entity
public class RefundRequest extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private Users user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(nullable = false)
    private String reason;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderItem_id",nullable = false)
    private OrderItem orderItem;
}
