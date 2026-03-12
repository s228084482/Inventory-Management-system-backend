package com.ims.ims_backend.controllers;

import com.ims.ims_backend.entities.ErrorResponse;
import com.ims.ims_backend.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException exception){
        ErrorResponse productNotFound = new ErrorResponse(LocalDateTime.now(), exception.getMessage(), "No product found.");
        return new ResponseEntity<>(productNotFound, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SupplierNotFoundException.class)
    public ResponseEntity<?> handleSupplierNotFoundException(SupplierNotFoundException exception){
        ErrorResponse supplierNotFound = new ErrorResponse(LocalDateTime.now(),exception.getMessage(),"Supplier not found");
        return new ResponseEntity<>(supplierNotFound,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<?> handleCategoryNotFoundException(CategoryNotFoundException e){
        ErrorResponse categoryNotFound = new ErrorResponse(LocalDateTime.now(),e.getMessage(), "Category not found");
        return new ResponseEntity<>(categoryNotFound, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException e){
        ErrorResponse userNotFound = new ErrorResponse(LocalDateTime.now(),e.getMessage(),"User not found");
        return new ResponseEntity<>(userNotFound,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(productExistsException.class)
    public ResponseEntity<?> handleProductExistException(productExistsException e){
        ErrorResponse productExist = new ErrorResponse(LocalDateTime.now(),e.getMessage(),"Product already exist.");
        return new ResponseEntity<>(productExist,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(SupplierExistException.class)
    public ResponseEntity<?> handleSupplierExistException(SupplierExistException e){
        ErrorResponse supplierAlreadyExist = new ErrorResponse(LocalDateTime.now(),e.getMessage(),"Supplier exist");
        return new ResponseEntity<>(supplierAlreadyExist,HttpStatus.CONFLICT);
    }
}
