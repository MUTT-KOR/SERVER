package com.mutt.mutt_BE.proposal.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * BaseProposal(Idea/Design)과 Color의 N:M 관계를 표현하는 중간 테이블
 * 하나의 제안이 여러 색상을 선택 가능
 *
 * @see BaseProposal
 * @see Idea
 * @see Design
 * @see Color
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "proposal_color")
@Builder
public class ProposalColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proposal_id",nullable = false)
    private BaseProposal idea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id",nullable = false)
    private Color color;


}
