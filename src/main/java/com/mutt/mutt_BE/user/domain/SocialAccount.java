package com.mutt.mutt_BE.user.domain;

import com.mutt.mutt_BE.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
/**
 * 하나의 Users가 여러 소셜 계정을 연결 가능
 *
 * 관계:
 * - N:1 → Users (소셜 계정 소유자)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "social_account")
@SuperBuilder
public class SocialAccount extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users user;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    private Long providerUserId;

}
