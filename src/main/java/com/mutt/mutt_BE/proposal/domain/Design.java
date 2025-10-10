package com.mutt.mutt_BE.proposal.domain;

import com.mutt.mutt_BE.global.enums.DesignStatus;
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
@DiscriminatorValue("DESIGN")
public class Design extends BaseProposal{

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DesignStatus status;
}
