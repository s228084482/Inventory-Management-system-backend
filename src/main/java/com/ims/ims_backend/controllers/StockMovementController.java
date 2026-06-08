package com.ims.ims_backend.controllers;

import com.ims.ims_backend.DataTransferObjects.StockMovementDTO;
import com.ims.ims_backend.services.StockMovementListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/allUsers/stockMovement")
public class StockMovementController {
    @Autowired
    private StockMovementListener stockMovementListener;
    @PostMapping("/saveStockMovement")
    public ResponseEntity<?> saveStockMovement(@RequestBody StockMovementDTO stock){
        return stockMovementListener.saveStockMovement(stock);
    }
    @GetMapping("/getStockHistory")
    public ResponseEntity<?> getStockHistory(){
        return stockMovementListener.getStockHistory();
    }
}
