package com.mutt.mutt_BE.common.domain;

import com.mutt.mutt_BE.common.enums.EntityType;
import com.mutt.mutt_BE.common.enums.FileType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;
/**
 * 파일
 * 상품, 아이디어, 리뷰 등에 첨부되는 이미지/파일을 관리
 * 다형성 연관(entityType + entityId)을 통해 여러 엔티티와 연결
 *
 * 기능:
 * - 메인 이미지 지정 (isMain)
 * - 파일 정렬 순서 (sortOrder)
 * - 중복 검사 (sha256 해시)
 *
 * 사용 예: Product의 상세 이미지, Review의 포토 리뷰
 */
@Entity
public class File extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String url;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FileType fileType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    @Column(nullable = false)
    private Long entityId;

    @Column(nullable = false)
    private boolean isMain;

    @Column(nullable = false)
    @Min(1)
    private int sortOrder;

    @Column(nullable = false)
    private String sha256;
}
