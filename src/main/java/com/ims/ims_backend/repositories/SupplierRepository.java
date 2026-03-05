package com.ims.ims_backend.repositories;

import com.ims.ims_backend.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    @Query(value="SELECT supplierid FROM supplier WHERE supplier_name = :supplier_name", nativeQuery = true)
    Long getSupplierId(@Param("supplier_name") String supplier_name);
    Boolean existsBySupplierName(String name);
}
