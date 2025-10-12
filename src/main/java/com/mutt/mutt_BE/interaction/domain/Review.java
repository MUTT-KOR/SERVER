package com.mutt.mutt_BE.interaction.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.order.domain.OrderItem;
import com.mutt.mutt_BE.product.domain.Product;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * 리뷰
 * 구매 확정 후 작성 가능한 상품 리뷰를 관리
 * OrderItem과 연결되어 구매자만 작성 가능하도록 검증
 *
 * 평점: 1.0 ~ 5.0 (0.5 단위)
 *
 * 관계:
 * - N:1 → Product (리뷰 대상 상품)
 * - N:1 → OrderItem (구매 내역)
 * - N:1 → Users (작성자)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "review")
@SuperBuilder
public class Review extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_item_id", nullable = false)
    private OrderItem orderItem;
    
    @Column(nullable = false,precision = 2,scale = 1)
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "5.0")
    private BigDecimal rating; // 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0
    
    @Column(length = 2000)
    private String content;

}
