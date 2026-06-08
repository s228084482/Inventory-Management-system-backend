package com.ims.ims_backend.DataTransferObjects;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class StockMovementDTO {
    private String productName;
    private String movementType;
    private Long qty;
    private Date date;

    public StockMovementDTO(String productName, String movementType, Long qty, Date date) {
        this.productName = productName;
        this.movementType = movementType;
        this.qty = qty;
        this.date = date;
    }

    public StockMovementDTO() {
    }
}
