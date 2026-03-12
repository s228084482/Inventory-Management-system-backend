package com.ims.ims_backend.services;

import com.ims.ims_backend.DataTransferObjects.ProductDTO;
import com.ims.ims_backend.entities.*;
import com.ims.ims_backend.exceptions.CategoryNotFoundException;
import com.ims.ims_backend.exceptions.ProductNotFoundException;
import com.ims.ims_backend.exceptions.SupplierNotFoundException;
import com.ims.ims_backend.exceptions.UserNotFoundException;
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
        var products = productRepository.findAll();
        if(products.isEmpty()){
            throw new ProductNotFoundException("No products found, Database is empty.");
        }else{
            return ResponseEntity.ok(products);
        }
    }

    @Override
    public boolean saveProduct(ProductDTO product) {
        boolean response = false;

        String productName = product.getProductName();
        float price = product.getPrice();
        Long quantity = product.getQuantity();
        String description = product.getDescription();
        String supplierName = product.getSupplierName();
        String move = product.getMove();
        String category_name = product.getCategory_name();
        String userName = product.getUser_name();

        Category category;
        Supplier supplier;
        Users user;

        if(!supplierRepository.existsBySupplierName(supplierName)){
            String message = "There is no supplier with this name: " + supplierName;
            throw new SupplierNotFoundException(message);
        }else{
            supplier = supplierRepository.getSupplier(supplierName);
        }
        if(!categoryRepository.existsCategoryByCategoryName(category_name)){
            String message = "There is no Category with this name: " + category_name;
            throw new CategoryNotFoundException(message);
        }else{
            category = categoryRepository.getCategory(category_name);
        }
        if(!userRepository.existsUsersByFullName(userName)){
            String message = "This user (" + userName + ") is not found, please try again.";
            throw new UserNotFoundException(message);
        }else{
            user = userRepository.getUser(userName);
        }

        if(supplier != null && category != null && user != null){
            Product toBeSavedProduct = new Product(user,supplier,category,productName,price,quantity,description, ProductStatus.available);

            if(!productRepository.existsProductByProductName(toBeSavedProduct.getProductName())){
                productRepository.save(toBeSavedProduct);
                response = true;
            }
        }

        return response;
    }

    @Override
    public ResponseEntity<?> DeleteProduct(Long id) {
        if(!productRepository.existsById(id))
            throw new ProductNotFoundException("Product you are trying to delete is not found please try again.");
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> editProduct(Long id,Product newProduct) {
        if(!productRepository.existsById(id))
            throw new ProductNotFoundException("Product you are trying to edit isn't found, please try again!");

//        productRepository.findById(id).map(product ->{
//
//        });
        return null;
    }
}
