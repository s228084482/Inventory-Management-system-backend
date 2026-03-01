package com.ims.ims_backend.services;

import com.ims.ims_backend.entities.Category;
import com.ims.ims_backend.entities.CategoryData;
import com.ims.ims_backend.repositories.CategoryRepository;
import com.ims.ims_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImplementation implements CategoryService{
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Set<CategoryData> getCategoryData() {
        Set<Category> categories = new HashSet<>(repository.findAll());
        return getAssignedProductAndPercentage(categories);
    }

    public Set<CategoryData> getAssignedProductAndPercentage(Set<Category> categorySet){
        Set<CategoryData> cData = new HashSet<>();
        for(Category c: categorySet){
            Long numberOfProductAssigned = productRepository.sizeOfSpecificId(c.getCategoryId());
            var percent = ((double)numberOfProductAssigned/productRepository.count()) * 100;
            CategoryData data = new CategoryData(c.getCategoryId(),c.getCategoryName(),numberOfProductAssigned, percent +"%");
            cData.add(data);
        }
        return cData;
    }

    @Override
    public ResponseEntity<Void> deleteCategory(long id) {
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Category> editCategory(long id, Category newCategory) {
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        return repository.findById(id).map(category ->{
            category.setCategoryName(newCategory.getCategoryName());

            Category saved = repository.save(category);

            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }
}
