package com.udea.aux_test.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRODUCT_NAME", nullable = false, unique = true)
    private String productName;

    @Column(name = "PRODUCT_PRICE", nullable = false, unique = true)
    private BigDecimal productPrice;

    @Column(name = "PRODUCT_IMAGE")
    private String productImage;

}
