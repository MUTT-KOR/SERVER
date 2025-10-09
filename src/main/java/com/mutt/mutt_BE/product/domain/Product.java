package com.mutt.mutt_BE.product.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.common.domain.Category;
import com.mutt.mutt_BE.common.domain.SizeInfo;
import com.mutt.mutt_BE.common.enums.ProductStatus;
import com.mutt.mutt_BE.idea.domain.Idea;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;

/**
 * 상품 엔티티
 * 판매 중인 상품 정보를 관리 (가격, 재고, 설명 등)
 * Idea로부터 생성되거나 독립적으로 등록 가능
 *
 * 관계:
 * - 1:N → ProductOption (상품 옵션)
 * - 1:N → Review (리뷰)
 * - 1:N → QnA (문의)
 * - 1:1 → Idea
 */
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Product extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idea_id",nullable = false)
    private Idea idea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(nullable = false)
    private boolean isAdult;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Embedded
    private SizeInfo sizeInfo;

    //최대 가격 :  99만원
    @Column(nullable = false, precision = 8, scale = 2)
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "999999.99")
    private BigDecimal basePrice;

    @Column(nullable = false)
    @Min(0)
    @Max(999)
    private Integer stockQuantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductStatus status;

    @Column(nullable = false)
    private String summaryLine;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String detailMarkdown;

}
