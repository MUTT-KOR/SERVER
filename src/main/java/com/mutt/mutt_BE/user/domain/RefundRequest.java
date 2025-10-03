package com.mutt.mutt_BE.user.domain;

import com.mutt.mutt_BE.common.enums.RefundStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class RefundRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private RefundStatus status;
    private LocalDateTime requestedAt;
    private String reason;


    //private OderItem orderItem;
}
