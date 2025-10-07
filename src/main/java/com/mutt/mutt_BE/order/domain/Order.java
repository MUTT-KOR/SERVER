package com.mutt.mutt_BE.order.domain;

import com.mutt.mutt_BE.address.domain.AddressSnapshot;
import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.common.enums.OrderStatus;
import com.mutt.mutt_BE.common.enums.OrderType;
import com.mutt.mutt_BE.address.domain.Address;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private Users user;


    @Column(nullable = false,precision = 9,scale = 2)
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "999999999.99")
    private BigDecimal totalPrice;

    @Column(nullable = false,precision = 7,scale = 2)
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "99999.99")
    private BigDecimal shippingFee; // 배송비

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id",nullable = false)
    private Address address;

    @Column(nullable = false)
    private OrderType orderType;

    @Embedded
    private AddressSnapshot addressSnapshot;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }
}
