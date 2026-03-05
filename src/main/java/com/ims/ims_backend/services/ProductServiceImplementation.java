package com.ims.ims_backend.services;

import com.ims.ims_backend.entities.ProductHolder;
import com.ims.ims_backend.exceptions.CategoryNotFoundException;
import com.ims.ims_backend.exceptions.ProductNotFoundException;
import com.ims.ims_backend.exceptions.SupplierNotFoundException;
import com.ims.ims_backend.repositories.CategoryRepository;
import com.ims.ims_backend.repositories.ProductRepository;
import com.ims.ims_backend.repositories.SupplierRepository;
import com.ims.ims_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplementation implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public ResponseEntity<?> getAll() {
        if(productRepository.findAll().isEmpty()){
            throw new ProductNotFoundException("No products found, Database is empty.");
        }else{
            var products = productRepository.findAll();
            return ResponseEntity.ok(products);
        }
    }

    @Override
    public ResponseEntity<Boolean> saveProduct(ProductHolder product) {
        String productName = product.getProductName();
        float price = product.getPrice();
        Long quantity = product.getQuantity();
        String description = product.getDescription();
        String supplierName = product.getSupplierName();
        String move = product.getMove();
        String category_name = product.getCategory_name();
        String userName = product.getUser_name();

        long category_id;
        long supplier_id;
        long user_id;

        if(!supplierRepository.existsBySupplierName(supplierName)){
            String message = "There is no supplier with this name: " + supplierName;
            throw new SupplierNotFoundException(message);
        }else{
            supplier_id = supplierRepository.getSupplierId(supplierName);
        }
        if(!categoryRepository.existsCategoryByCategoryName(category_name)){
            String message = "There is no Category with this name: " + category_name;
            throw new CategoryNotFoundException(message);
        }else{
            category_id = categoryRepository.getCategoryId(category_name);
        }

        return null;
    }
}
