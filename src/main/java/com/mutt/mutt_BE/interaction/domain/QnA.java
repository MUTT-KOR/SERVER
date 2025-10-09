package com.mutt.mutt_BE.interaction.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.product.domain.Product;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
/**
 *
 *관리자(mutt)가 답변 가능하며, 답변 여부 추적가능.
 *
 * 관계:
 * - N:1 → Product (문의 대상 상품)
 * - N:1 → Users (문의 작성자)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class QnA extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(nullable = false,length = 2000)
    private String question;

    @Column(nullable = false)
    private boolean isAnswered;

    @Column(length = 2000)
    private String answer;

    private LocalDateTime answeredAt;
}
