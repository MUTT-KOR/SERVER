package com.mutt.mutt_BE.order.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.product.domain.Product;
import com.mutt.mutt_BE.product.domain.ProductOption;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;


/**
 * 주문 항목 엔티티
 * 주문에 포함된 개별 상품 정보를 관리 (상품, 수량, 가격 등)
 * Order의 생명주기에 종속,
 * TODO : linePrice는 자동 계산처리하기
 * 계산식: linePrice = unitPrice × quantity으로 우선 처리.
 *
 * @see Order
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "order_item")
@SuperBuilder
public class OrderItem extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_id",nullable = false)
    private ProductOption productOption;

    @Column(nullable = false)
    @Min(1)
    @Max(999)
    private Integer quantity;

    //최대 99만원
    @Column(nullable = false, precision = 8, scale = 2)
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "999999.99")
    private BigDecimal unitPrice;

    //최대 999만원
    @Column(nullable = false,precision = 9,scale = 2)
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "9999999.99")
    private BigDecimal linePrice;

    //TODO : productOption고려해서 계산 수정
    @PrePersist
    @PreUpdate
    public void calculateSubTotalPrice(){
         this.linePrice = this.unitPrice.multiply(new BigDecimal(this.quantity));
    }
}
