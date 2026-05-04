package com.ims.ims_backend.services;

import com.ims.ims_backend.DataTransferObjects.EditProductDTO;
import com.ims.ims_backend.DataTransferObjects.ProductDTO;
import com.ims.ims_backend.entities.*;
import com.ims.ims_backend.exceptions.*;
import com.ims.ims_backend.repositories.CategoryRepository;
import com.ims.ims_backend.repositories.ProductRepository;
import com.ims.ims_backend.repositories.SupplierRepository;
import com.ims.ims_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<Users> user;

        if(!supplierRepository.existsBySupplierName(supplierName)){
            String message = "There is no supplier with this name: " + supplierName;
            System.out.println(message);
            throw new SupplierNotFoundException(message);
        }else{
            supplier = supplierRepository.getSupplier(supplierName);
        }
        if(!categoryRepository.existsCategoryByCategoryName(category_name)){
            String message = "There is no Category with this name: " + category_name;
            System.out.println(message);
            throw new CategoryNotFoundException(message);
        }else{
            category = categoryRepository.getCategory(category_name);
        }
        if(!userRepository.existsUsersByFullName(userName)){
            String message = "This user (" + userName + ") is not found, please try again.";
            System.out.println(message);
            throw new UserNotFoundException(message);
        }else{
            user = userRepository.findUsersByFullName(userName);
        }

        if(supplier != null && category != null && user.isPresent()){
            System.out.println("They are not null,");
            Product toBeSavedProduct = new Product(user.get(),supplier,category,productName,price,quantity,description, ProductStatus.available);

            if(!productRepository.existsProductByProductName(toBeSavedProduct.getProductName())){
                System.out.println("Product has been successfully save.");
                productRepository.save(toBeSavedProduct);
                response = true;
            }
        }
        System.out.println(response);

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
    public Optional<ResponseEntity<Product>> editProduct(Long id, EditProductDTO newProduct) {
        if(!productRepository.existsById(id))
            throw new ProductNotFoundException("Product you are trying to edit isn't found, please try again!");

        return productRepository.findById(id).map(product ->{
            if(product.getProductName().equals(newProduct.getProductName()) &&
                    (product.getPrice() == newProduct.getPrice()) && product.getQty() == newProduct.getQuantity()
            && product.getDescription().equals(newProduct.getDescription())){
                throw new NoChangesException("No changes made.");
            }

            if(!product.getProductName().equals(newProduct.getProductName())){
                product.setProductName(newProduct.getProductName());
            }
            if(!(product.getPrice() == newProduct.getPrice())){
                product.setPrice(newProduct.getPrice());
            }
            if(!product.getQty().equals(newProduct.getQuantity())){
                product.setQty(newProduct.getQuantity());
            }
            if(!product.getDescription().equals(newProduct.getDescription())){
                product.setDescription(newProduct.getDescription());
            }

            return ResponseEntity.ok(productRepository.save(product));
        });
    }

    @Override
    public long countProducts() {
        long size = productRepository.count();
        if(size >= 1)
            return size;
        else return 0;
    }
}
