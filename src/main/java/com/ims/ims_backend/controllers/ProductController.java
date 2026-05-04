package com.ims.ims_backend.controllers;

import com.ims.ims_backend.DataTransferObjects.EditProductDTO;
import com.ims.ims_backend.entities.Product;
import com.ims.ims_backend.DataTransferObjects.ProductDTO;
import com.ims.ims_backend.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/save")
    public Boolean saveProduct(@RequestBody ProductDTO product){
        return service.saveProduct(product);
    }
    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts(){
        return service.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteProduct(@PathVariable Long id){
        return service.DeleteProduct(id);
    }
    @PutMapping("/{id}")
    public Optional<ResponseEntity<Product>> editProduct(@PathVariable Long id,@RequestBody EditProductDTO product){
        return service.editProduct(id,product);
    }
    @GetMapping("/totalProducts")
    public long countTotalProducts(){
        return service.countProducts();
    }
}
