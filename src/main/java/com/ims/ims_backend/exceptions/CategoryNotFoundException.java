package com.ims.ims_backend.exceptions;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message, String category_name){
        super(message);
    }
}
