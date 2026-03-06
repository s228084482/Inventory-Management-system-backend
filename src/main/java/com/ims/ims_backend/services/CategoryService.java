package com.ims.ims_backend.services;

import com.ims.ims_backend.entities.Category;
import com.ims.ims_backend.DataTransferObjects.CategoryDTO;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface CategoryService {
    Set<CategoryDTO> getCategoryData();

    ResponseEntity<Void> deleteCategory(long id);

    ResponseEntity<Category> editCategory(long id, Category category);

    ResponseEntity<Boolean>  save(Category category);
}
