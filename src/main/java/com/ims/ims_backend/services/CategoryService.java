package com.ims.ims_backend.services;

import com.ims.ims_backend.entities.Category;
import com.ims.ims_backend.entities.CategoryData;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    Set<CategoryData> getCategoryData();

    ResponseEntity<Void> deleteCategory(long id);

    ResponseEntity<Category> editCategory(long id, Category category);

    Category save(Category category);
}
