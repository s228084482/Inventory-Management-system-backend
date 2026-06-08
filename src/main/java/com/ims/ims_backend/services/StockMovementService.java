package com.ims.ims_backend.services;

import com.ims.ims_backend.DataTransferObjects.StockMovementDTO;
import com.ims.ims_backend.entities.Movement;
import com.ims.ims_backend.entities.Product;
import com.ims.ims_backend.entities.StockMovement;
import com.ims.ims_backend.exceptions.ProductNotFoundException;
import com.ims.ims_backend.exceptions.QuantityNotGoodException;
import com.ims.ims_backend.exceptions.productExistsException;
import com.ims.ims_backend.repositories.ProductRepository;
import com.ims.ims_backend.repositories.StockMovementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StockMovementService implements StockMovementListener {
    @Autowired
    private StockMovementRepository stockMovementRepository;
    @Autowired
    private ProductRepository productRepository;
    private static final Logger log = LoggerFactory.getLogger(StockMovementService.class);

    @Override
    public ResponseEntity<?> saveStockMovement(StockMovementDTO stock) {
        if(!productRepository.existsProductByProductName(stock.getProductName())){
            throw new ProductNotFoundException("The product trying to update isn't found, please check product name");
        }
        Product product = productRepository.getProductByProductName(stock.getProductName());

        StockMovement stockMovement;
        if(stock.getMovementType().equals("In")){
            product.setQty(product.getQty() + stock.getQty());
            stockMovement = new StockMovement(product, stock.getQty(), Movement.In,stock.getDate());
        }
        else{

            if(stock.getQty() > product.getQty())
                throw new QuantityNotGoodException("Quantity entered is greater then the available product quantity.");

            product.setQty(product.getQty() - stock.getQty());

            stockMovement = new StockMovement(product, stock.getQty(), Movement.Out,stock.getDate());
        }

        productRepository.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(stockMovementRepository.save(stockMovement));
    }

    @Override
    public ResponseEntity<?> getStockHistory() {
        List<StockMovement> stockMovementList = stockMovementRepository.findAll();
        if(stockMovementList.isEmpty())
            throw new productExistsException("No Stock history available.");

        List<StockMovementDTO> list = stockMovementList.stream().map(stockMovement ->{

            StockMovementDTO stm = new StockMovementDTO();

            stm.setMovementType(stockMovement.getProduct().getProductName());
            stm.setMovementType(stockMovement.getMovementType().name());
            stm.setQty(stockMovement.getStockQty());
            stm.setDate(stockMovement.getDate());

            return stm;
        }).toList();
        
        if(list.isEmpty())
            throw new productExistsException("No Stock history available.");
        log.info("This is a list to be returned: ", stockMovementList);

        return ResponseEntity.ok(list);
    }
}
