package com.ims.ims_backend.controllers;

import com.ims.ims_backend.entities.Product;
import com.ims.ims_backend.entities.ProductInfo;
import com.ims.ims_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/save")
    public String saveProduct(){

        return "Ok";
    }
    @PostMapping("/saveProductInfo")
    public ResponseEntity<String> saveProductInfoData(@RequestBody ProductInfo productInfo){
        return service.saveProductInfo(productInfo);
    }
    @GetMapping("/getByProductName")
    public Product getByName(@RequestBody String productName){
        return null;
    }

    @GetMapping("/getAllProducts")
    public Set<Product> getAllProducts(){
        return service.getAll();
    }
}
