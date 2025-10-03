package com.mutt.mutt_BE.common.domain;

import com.mutt.mutt_BE.common.enums.NotificationType;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private String message;
    private NotificationType type;
    private boolean isRead;
    private LocalDateTime createdAt;
    private LocalDateTime readAt;

}
