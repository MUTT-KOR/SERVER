package com.mutt.mutt_BE.order.domain;

import com.mutt.mutt_BE.common.enums.OrderStatus;
import com.mutt.mutt_BE.user_data.domain.Address;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private Long totalAmount;
    private LocalDateTime orderedAt;
    private Long shippingFee; // 배송비
    private OrderStatus status;
    private Address address;

}
