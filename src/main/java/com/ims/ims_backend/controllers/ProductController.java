package com.ims.ims_backend.controllers;

import com.ims.ims_backend.entities.Product;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @PostMapping("/save")
    public String saveProduct(@RequestParam String name, @RequestParam float price, @RequestParam long qty,@RequestParam String description){

        return "Ok";
    }
    @PostMapping("/saveProductInfo")
    public String saveProductInfoData(){

        return "Ok";
    }
    @GetMapping("/getByProductName")
    public Product getByName(@RequestBody String productName){
        return null;
    }
}
