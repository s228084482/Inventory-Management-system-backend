package com.ims.ims_backend.services;

import com.ims.ims_backend.entities.Category;
import com.ims.ims_backend.DataTransferObjects.CategoryDTO;
import com.ims.ims_backend.exceptions.CategoryNotFoundException;
import com.ims.ims_backend.repositories.CategoryRepository;
import com.ims.ims_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImplementation implements CategoryService{
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Set<CategoryDTO> getCategoryData() {
        Set<Category> categories = new HashSet<>(repository.findAll());
        return getAssignedProductAndPercentage(categories);
    }

    public Set<CategoryDTO> getAssignedProductAndPercentage(Set<Category> categorySet){
        Set<CategoryDTO> cData = new HashSet<>();
        for(Category c: categorySet){
            Long numberOfProductAssigned = productRepository.sizeOfSpecificId(c.getCategoryId());
            var percent = ((double)numberOfProductAssigned/productRepository.count()) * 100;
            CategoryDTO data = new CategoryDTO(c.getCategoryId(),c.getCategoryName(),numberOfProductAssigned, percent +"%");
            cData.add(data);
        }
        return cData;
    }

    @Override
    public ResponseEntity<Void> deleteCategory(long id) {
        if(!repository.existsById(id)){
            throw new CategoryNotFoundException("Category that you are trying to delete isn't found, please try again!");
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Category> editCategory(long id, Category newCategory) {
        if(!repository.existsById(id)){
            throw new CategoryNotFoundException("Category that you are trying to edit isn't found, please try again!");
        }
        return repository.findById(id).map(category ->{
            if(!newCategory.getCategoryName().equals(category.getCategoryName())){
                category.setCategoryName(newCategory.getCategoryName());
            }

            Category saved = repository.save(category);

            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Boolean> save(Category category) {
        boolean exist = repository.existsByName(category.getCategoryName()) > 0;
        if(!exist){
            repository.save(category);
        }
        return ResponseEntity.ok(exist);
    }
}
