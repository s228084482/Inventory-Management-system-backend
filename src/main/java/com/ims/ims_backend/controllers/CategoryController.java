package com.ims.ims_backend.controllers;

import com.ims.ims_backend.entities.Category;
import com.ims.ims_backend.entities.CategoryData;
import com.ims.ims_backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService service;
    @GetMapping("/getAllCategoryData")
    public Set<CategoryData> getCategoryData(){
        return service.getCategoryData();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long id){
        return service.deleteCategory(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> editCategory(@PathVariable long id, @PathVariable Category category){
        return service.editCategory(id,category);
    }
    @PostMapping
    public Category saveCategory(@RequestBody Category category){
        return service.save(category);
    }
}
