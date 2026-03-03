package com.ims.ims_backend.services;

import com.ims.ims_backend.entities.Product;
import com.ims.ims_backend.entities.ProductInfo;
import com.ims.ims_backend.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductServiceImplementation implements ProductService{
    private ProductRepository productRepository;
    @Override
    public Set<Product> getAll() {
        return new HashSet<>(productRepository.findAll());
    }

    @Override
    public ResponseEntity<String> saveProductInfo(ProductInfo productInfo) {
        return null;
    }
}
