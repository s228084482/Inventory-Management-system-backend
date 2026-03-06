package com.ims.ims_backend.services;

import com.ims.ims_backend.DataTransferObjects.ProductDTO;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> getAll();
    boolean saveProduct(ProductDTO product);

    ResponseEntity<?> DeleteProduct(Long id);
}
