package com.ims.ims_backend.exceptions;

public class SupplierExistException extends RuntimeException{
    public SupplierExistException(String message){
        super(message);
    }
}
