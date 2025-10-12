package com.mutt.mutt_BE.proposal.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.common.domain.Category;
import com.mutt.mutt_BE.common.domain.SizeInfo;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * 제안(아이디어/도안) 공통 추상 엔티티
 * Idea와 Design의 공통 속성을 관리
 * 
 * 단일 테이블 전략(SINGLE_TABLE) 사용:
 * - 성능 최적화 (JOIN 불필요)
 * - 단순한 스키마
 * - proposal_type으로 구분
 * 
 * 공통 기능:
 * - 등록비 결제 후 검토 프로세스
 * - 승인 시 Product로 전환
 * - 색상, 사이즈, 카테고리 관리
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "proposal_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
public abstract class BaseProposal extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String requiredFeatures;

    @Column(nullable = false)
    private boolean isFeePaid;

    @Column(nullable = false)
    private boolean isAdult;

    @Embedded
    private SizeInfo sizeInfo;
}
