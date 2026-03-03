package com.ims.ims_backend.repositories;

import com.ims.ims_backend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "SELECT EXISTS (SELECT 1 FORM Category WHERE categoryName = :categoryName)", nativeQuery = true)
    boolean existsByName(@Param("categoryName") String categoryName);
}
