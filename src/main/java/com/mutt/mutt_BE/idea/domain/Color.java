package com.mutt.mutt_BE.idea.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
/**
 * 색상 마스터 엔티티
 * 아이디어에서 선택 가능한 색상 정보를 관리
 * 공통으로 사용하는 색상 코드표
 *
 * 예: "빨강(#FF0000)", "파랑(#0000FF)"
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "color")
@Builder
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String hexCode;

    @Column(nullable = false)
    private boolean isActive;
}
