package com.mutt.mutt_BE.admin.domain;

import com.mutt.mutt_BE.user.domain.Account;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
/**
 * 관리자 엔티티
 * 자체 비밀번호 인증 방식 사용
 *
 * @see Account
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "admin")
@SuperBuilder
public class Admin extends Account {

    @Column(nullable = false)
    private String password_hash;
}
