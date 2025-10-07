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
    @JoinColumn(name = "idea_id")
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

    @Column(nullable = false, precision = 10, scale = 2)
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "999999999.99")
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
