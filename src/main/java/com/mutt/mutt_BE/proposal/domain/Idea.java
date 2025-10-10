package com.mutt.mutt_BE.proposal.domain;

import com.mutt.mutt_BE.global.enums.IdeaStatus;
import jakarta.persistence.*;
import lombok.*;


import lombok.experimental.SuperBuilder;

/**
 * 아이디어 엔티티
 * 등록비 결제 후 검토를 거쳐 Product로 전환
 *
 * 관계:
 * - 1:N → IdeaColor (아이디어 색상)
 * - 1:1 → IdeaFeeTransaction (등록비 결제)
 * - 1:1 ← Product (승인 시 생성)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
@DiscriminatorValue("IDEA")
public class Idea extends BaseProposal {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IdeaStatus status;

}
