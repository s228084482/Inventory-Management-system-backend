package com.ims.ims_backend.services;

import com.ims.ims_backend.entities.Product;
import com.ims.ims_backend.entities.ProductHolder;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface ProductService {
    ResponseEntity<?> getAll();
    ResponseEntity<Boolean> saveProduct(ProductHolder product);
}
