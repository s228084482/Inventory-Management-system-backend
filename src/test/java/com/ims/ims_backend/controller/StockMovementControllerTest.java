package com.ims.ims_backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ims.ims_backend.DataTransferObjects.StockMovementDTO;
import com.ims.ims_backend.controllers.StockMovementController;
import com.ims.ims_backend.services.StockMovementListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(StockMovementController.class)
public class StockMovementControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StockMovementListener stockMovementListener;
    @Autowired
    private ObjectMapper objectMapper;

    private StockMovementDTO stockMovementDTO;

//    private String productName;
//    private String movementType;
//    private Long qty;
//    private Date date;

    @BeforeEach
    void setUp(){
        long v = 100;
        stockMovementDTO = new StockMovementDTO("Cake","In",v, new Date(String.valueOf(LocalDate.now())));
    }
    @Test
    void shouldSaveStockMovement() throws Exception{
//        when(stockMovementListener.saveStockMovement(any(StockMovementDTO.class)))
//                .thenReturn(StockMovementDTO);
//
//        mockMvc.perform(post("/saveStockMovement"))
    }
}
