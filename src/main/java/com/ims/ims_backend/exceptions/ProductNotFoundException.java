package com.ims.ims_backend.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message){
        super((message));
    }
}
