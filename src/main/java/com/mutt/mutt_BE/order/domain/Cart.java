package com.mutt.mutt_BE.order.domain;

import com.mutt.mutt_BE.product.domain.Product;
import com.mutt.mutt_BE.product.domain.ProductOption;
import com.mutt.mutt_BE.user.domain.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Users user;
    private Product product;
    private ProductOption productOption;;
    private Long quantity;
    private boolean isChecked;

}
