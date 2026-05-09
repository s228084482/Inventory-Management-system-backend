package com.ims.ims_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@Entity
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stockId;
    @ManyToOne
    @JoinColumn(name = "productId",nullable = false)
    private Product product;
    @Column(nullable = false)
    private Long stockQty;
    @Column(nullable = false)
    private Movement movementType;
    @Column(nullable = false)
    private Date date;

    public StockMovement(Product product, Long stockQty, Movement movementType, Date date) {
        this.product = product;
        this.stockQty = stockQty;
        this.movementType = movementType;
        this.date = date;
    }

    public StockMovement() {

    }
}
