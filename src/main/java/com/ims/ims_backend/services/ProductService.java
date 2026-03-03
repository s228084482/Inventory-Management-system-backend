package com.ims.ims_backend.services;

import com.ims.ims_backend.entities.Product;
import com.ims.ims_backend.entities.ProductInfo;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface ProductService {
    Set<Product> getAll();

    ResponseEntity<String> saveProductInfo(ProductInfo productInfo);
}
