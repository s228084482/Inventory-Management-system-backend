package com.ims.ims_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private Users user;
    @ManyToOne
    @JoinColumn(name = "supplierID", nullable = false)
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false)
    private Long qty;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private ProductStatus status;

    public Product(Long productId, String productName, float price, Long qty, String description, ProductStatus status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.qty = qty;
        this.description = description;
        this.status = status;
    }
}
