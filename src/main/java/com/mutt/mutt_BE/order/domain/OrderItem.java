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

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
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

    @Column(nullable = false,precision = 9,scale = 2)
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "999999999.99")
    private BigDecimal unitPrice;

    @Column(nullable = false,precision = 9,scale = 2)
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "999999999.99")
    private BigDecimal linePrice;

    //TODO : productOption고려해서 계산 수정
    @PrePersist
    @PreUpdate
    public void calculateSubTotalPrice(){
         this.linePrice = this.unitPrice.multiply(new BigDecimal(this.quantity));
    }
}
