package com.mutt.mutt_BE.idea.domain;

import com.mutt.mutt_BE.common.domain.Category;
import com.mutt.mutt_BE.common.enums.IdeaStatus;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private Category category;
    private String title;
    //따로 빼기.
    private Double width;
    private Double height;
    private Double length;
    private String dimensionUnit;
    private String description;
    private String requiredFeatures;
    private IdeaStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isFeePaid;
    private boolean isAdult;


}
