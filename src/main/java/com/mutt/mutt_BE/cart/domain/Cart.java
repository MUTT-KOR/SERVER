package com.mutt.mutt_BE.cart.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
/**
 * 장바구니 엔티티
 * 사용자의 장바구니를 관리하며, 여러 CartItem을 포함
 * Users와 1:1 관계 (사용자당 하나의 장바구니)
 *
 * 양방향 관계:
 * - 1:N ↔ CartItem (장바구니 항목, Cascade.ALL + orphanRemoval)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Cart extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private Users user;

    @OneToMany(
            mappedBy = "cart"
            ,fetch = FetchType.LAZY
            ,cascade = CascadeType.ALL
            ,orphanRemoval = true)
    private List<CartItem> cartItems;

}
