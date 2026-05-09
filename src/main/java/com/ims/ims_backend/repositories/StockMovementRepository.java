package com.ims.ims_backend.repositories;

import com.ims.ims_backend.entities.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<StockMovement,Long> {
}
