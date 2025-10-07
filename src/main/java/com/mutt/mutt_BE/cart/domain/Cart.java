package com.mutt.mutt_BE.cart.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
