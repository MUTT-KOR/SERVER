package com.mutt.mutt_BE.order.domain;

import com.mutt.mutt_BE.product.domain.Product;
import com.mutt.mutt_BE.product.domain.ProductOption;
import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Product product;
    private ProductOption productOption;
    private Long quantity;
    private Double unitPrice;
    private Double subTotalPrice;
}
