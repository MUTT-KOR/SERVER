package com.mutt.mutt_BE.cart.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.product.domain.Product;
import com.mutt.mutt_BE.product.domain.ProductOption;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * 장바구니 항목 엔티티
 * 장바구니에 담긴 개별 상품 정보를 관리 (상품, 옵션, 수량 등)
 * Cart의 생명주기에 종속되며, 선택 여부(isChecked)로 주문 대상 관리
 *
 * @see Cart
 */

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "cart_item")
@SuperBuilder
public class CartItem extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_id",nullable = false)
    private ProductOption productOption;

    @Column(nullable = false)
    @Min(1)
    @Max(999)
    private Integer  quantity;

    @Column(nullable = false)
    private boolean isChecked;


}
