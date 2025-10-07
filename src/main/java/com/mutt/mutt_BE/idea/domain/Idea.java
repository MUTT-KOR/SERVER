package com.mutt.mutt_BE.idea.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import com.mutt.mutt_BE.common.domain.Category;
import com.mutt.mutt_BE.common.enums.IdeaStatus;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import lombok.*;


import com.mutt.mutt_BE.common.domain.SizeInfo;
import jakarta.persistence.Embedded;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Idea extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String requiredFeatures;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IdeaStatus status;

    @Column(nullable = false)
    @JsonProperty("isFeePaid")
    private boolean isFeePaid;

    @Column(nullable = false)
    @JsonProperty("isAdult")
    private boolean isAdult;

    @Embedded
    private SizeInfo sizeInfo;

}
