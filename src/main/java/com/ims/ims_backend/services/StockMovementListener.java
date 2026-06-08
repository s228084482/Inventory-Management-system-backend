package com.ims.ims_backend.services;

import com.ims.ims_backend.DataTransferObjects.StockMovementDTO;
import org.springframework.http.ResponseEntity;

public interface StockMovementListener {
    ResponseEntity<?> saveStockMovement(StockMovementDTO stock);

    ResponseEntity<?> getStockHistory();
}
