package com.ims.ims_backend.repositories;

import com.ims.ims_backend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "SELECT COUNT(*) FROM category WHERE category_name = :category_name", nativeQuery = true)
    int existsByName(@Param("category_name") String category_name);
    @Query(value="SELECT category_id FROM category WHERE category_name = :category_name", nativeQuery = true)
    long getCategoryId(@Param("category_name") String category_name);
}
