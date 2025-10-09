package com.mutt.mutt_BE.idea.domain;

import com.mutt.mutt_BE.address.domain.AddressSnapshot;
import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.common.enums.PgProvider;
import com.mutt.mutt_BE.common.enums.TransactionStatus;
import com.mutt.mutt_BE.user.domain.Users;
import com.mutt.mutt_BE.address.domain.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * 아이디어 등록비 결제 엔티티
 * 아이디어 제안 시 발생하는 등록비 결제 정보를 관리
 * PG사 연동을 통해 실제 결제 처리하며, 배송지 정보도 스냅샷으로 보관
 *
 * TODO 결제 성공 시 Idea.isFeePaid = true 업데이트
 *
 * @see Idea
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IdeaFeeTransaction extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private Users user;

    @Column(nullable = false)
    private boolean isUserVerified;

    @OneToOne(fetch = FetchType.LAZY)
    private Idea idea;

    //최대 9만원
    @Column(nullable = false,precision = 7,scale = 2)
    @DecimalMin(value = "0.00")
    @DecimalMax(value = "99999.99")
    private BigDecimal ideaFee;


    @Column(nullable = false)
    private LocalDateTime transactedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id",nullable = false)
    private Address address;

    @Embedded
    private AddressSnapshot addressSnapshot;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PgProvider pgProvider;

    @Column(nullable = false,unique = true)
    private String pgTransactionId;
}
