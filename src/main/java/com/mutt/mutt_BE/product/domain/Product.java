package com.mutt.mutt_BE.product.domain;

import com.mutt.mutt_BE.common.domain.Category;
import com.mutt.mutt_BE.common.enums.ProductStatus;
import com.mutt.mutt_BE.idea.domain.Idea;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Idea idea;
    private Users user;
    private boolean isAdult;
    private String title;
    private Category category;
    private Double width;
    private Double height;
    private Double length;
    private String dimensionUnit;
    private Long basePrice;
    private Long stockQuantity;
    private ProductStatus status;
    private String summanyLine;
    private String detailMarkdown;

}
