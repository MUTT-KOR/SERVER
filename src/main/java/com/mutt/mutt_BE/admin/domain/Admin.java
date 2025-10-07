package com.mutt.mutt_BE.admin.domain;

import com.mutt.mutt_BE.user.domain.Account;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
public class Admin extends Account {


    @Column(nullable = false)
    private String password_hash;
}
