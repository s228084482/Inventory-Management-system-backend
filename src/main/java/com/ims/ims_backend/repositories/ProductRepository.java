package com.ims.ims_backend.repositories;

import com.ims.ims_backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value= "SELECT COUNT(*) FROM Product WHERE category_id = :category_id", nativeQuery = true)
    Long sizeOfSpecificId(@Param("category_id") Long category_id);
}
