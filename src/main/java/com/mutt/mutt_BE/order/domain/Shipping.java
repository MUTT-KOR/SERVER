package com.mutt.mutt_BE.order.domain;

import com.mutt.mutt_BE.common.enums.ShippingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Order order;
    private String trackingNumber;
    private String carrier;
    private ShippingStatus status;
    private String request;
    private LocalDateTime shippedAt;
    private LocalDateTime deliveredAt;
}
