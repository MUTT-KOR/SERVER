package com.mutt.mutt_BE.common.domain;

import com.mutt.mutt_BE.common.enums.NotificationType;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
/**
 * 알림
 * 읽음/안읽음 상태를 추적하여 미확인 알림 표시 가능
 *
 * 관계:
 * - N:1 → Users (알림 수신자)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Notification extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(nullable = false)
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType type;

    @Column(nullable = false)
    private boolean isRead;

    private LocalDateTime readAt;
}
