package com.udea.aux_test.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "total_products", nullable = false)
    private int totalProducts;
}
