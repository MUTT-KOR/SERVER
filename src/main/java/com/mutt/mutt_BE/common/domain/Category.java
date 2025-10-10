package com.mutt.mutt_BE.common.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
/**
 * 카테고리 엔티티
 * 아직 카테고리 세분화가 안되어있기 때문에 parentId = 0을 기본값으로.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "category")
@SuperBuilder
public class Category extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Min(0)
    private Long parentId;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;


}
