package com.ims.ims_backend.services;

import com.ims.ims_backend.DataTransferObjects.EditProductDTO;
import com.ims.ims_backend.DataTransferObjects.ProductDTO;
import com.ims.ims_backend.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ProductService {
    ResponseEntity<?> getAll();
    boolean saveProduct(ProductDTO product);

    ResponseEntity<?> DeleteProduct(Long id);

    Optional<ResponseEntity<Product>> editProduct(Long id, EditProductDTO product);

    long countProducts();
}
