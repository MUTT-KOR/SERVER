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


/**
 * 주문 엔티티
 * 사용자의 주문 정보를 관리 (총 금액, 배송지, 상태 등)
 * 여러 개의 OrderItem으로 구성되며, Payment와 1:1 연관
 *
 * 양방향 관계:
 * - 1:N ↔ OrderItem (주문 항목, Cascade.ALL + orphanRemoval)
 *
 * 단방향 관계:
 * - N:1 → Users (주문자)
 * - N:1 → Address (배송지)
 * - 1:1 → Payment (결제)
 * - 1:1 → Shipping (배송)
 */
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
    @DecimalMax(value = "9999999.99")
    private BigDecimal totalPrice;

    @Column(nullable = false,precision = 7,scale = 2)
    @DecimalMin(value = "0.00")
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
