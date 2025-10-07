package com.mutt.mutt_BE.payment.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.common.enums.PaymentMethodType;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;

@Entity
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
