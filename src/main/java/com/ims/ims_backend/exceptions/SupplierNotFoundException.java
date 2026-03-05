package com.ims.ims_backend.exceptions;

public class SupplierNotFoundException extends RuntimeException{
    public SupplierNotFoundException(String message){
        super(message);
    }
}
