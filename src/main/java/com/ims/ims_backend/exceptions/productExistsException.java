package com.ims.ims_backend.exceptions;

public class productExistsException extends RuntimeException{
    public productExistsException(String message){
        super(message);
    }
}
