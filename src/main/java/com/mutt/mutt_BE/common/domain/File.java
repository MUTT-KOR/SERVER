package com.mutt.mutt_BE.common.domain;

import com.mutt.mutt_BE.common.enums.EntityType;
import com.mutt.mutt_BE.common.enums.FileType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private FileType fileType;
    private EntityType entityType;
    private Long entityId;
    private boolean isMain;
    private int sortOrder;
    private LocalDateTime uploadedAt;
    private String sha256;
}
