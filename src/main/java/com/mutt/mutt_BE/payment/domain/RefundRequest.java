package com.mutt.mutt_BE.payment.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.global.enums.TransactionStatus;
import com.mutt.mutt_BE.order.domain.OrderItem;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import lombok.*;


/**
 * TODO 수정 필요 : 추후 확장으로 임시로 만들어둠!
 * 환불 요청 엔티티
 * 주문 항목에 대한 환불 요청을 관리 (사유, 상태 등)
 * 부분 환불을 지원하기 위해 OrderItem 단위로 연결
 *
 * 관계:
 * - 1:1 → OrderItem (환불 대상 항목)
 * - N:1 → Users (환불 요청자)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class RefundRequest extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private Users user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(nullable = false)
    private String reason;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderItem_id",nullable = false)
    private OrderItem orderItem;
}
