package com.mutt.mutt_BE.idea.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * 아이디어-색상 매핑 엔티티
 * Idea와 Color의 N:M 관계를 표현하는 중간 테이블
 * 하나의 아이디어가 여러 색상을 선택 가능
 *
 * @see Idea
 * @see Color
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class IdeaColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idea_id",nullable = false)
    private Idea idea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id",nullable = false)
    private Color color;


}
