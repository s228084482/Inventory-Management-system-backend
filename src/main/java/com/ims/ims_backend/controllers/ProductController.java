package com.ims.ims_backend.controllers;

import com.ims.ims_backend.entities.Product;
import com.ims.ims_backend.DataTransferObjects.ProductDTO;
import com.ims.ims_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/getByProductName")
    public Product getByName(@RequestBody String productName){
        return null;
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts(){
        return service.getAll();
    }
    @DeleteMapping("${id}")
    public ResponseEntity<?> DeleteProduct(@PathVariable Long id){
        return service.DeleteProduct(id);
    }
}
