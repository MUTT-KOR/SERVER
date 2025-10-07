package com.mutt.mutt_BE.common.domain;

import com.mutt.mutt_BE.common.enums.EntityType;
import com.mutt.mutt_BE.common.enums.FileType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

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

    @Column(nullable = false,columnDefinition = "default=0")
    private int sortOrder;

    @Column(nullable = false)
    private String sha256;
}
