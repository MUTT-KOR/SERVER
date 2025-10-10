package com.mutt.mutt_BE.product.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;


/**
 * 상품 옵션 엔티티
 * 상품의 선택 옵션을 관리 (색상, 사이즈 등)
 * 각 옵션별 추가 가격과 재고를 독립적으로 관리
 *
 * 예: "사이즈: 소, 추가금액: +1000원, 재고: 10개"
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "product_option")
@SuperBuilder
public class ProductOption extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    @Column(nullable = false)
    private String name;

    private String value;
    
    @Column(nullable = false, precision = 7, scale = 2)
    @DecimalMin(value = "0.00")
    @DecimalMax(value = "99999.99")
    private BigDecimal price;
    
    @Column(nullable = false)
    private Integer stockQuantity;
}
