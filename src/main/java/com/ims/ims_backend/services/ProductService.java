package com.ims.ims_backend.services;

import com.ims.ims_backend.DataTransferObjects.ProductDTO;
import com.ims.ims_backend.entities.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> getAll();
    boolean saveProduct(ProductDTO product);

    ResponseEntity<?> DeleteProduct(Long id);

    ResponseEntity<?> editProduct(Long id, Product product);

    long countProducts();
}
