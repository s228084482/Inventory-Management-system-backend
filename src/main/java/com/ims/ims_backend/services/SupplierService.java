package com.ims.ims_backend.services;

import com.ims.ims_backend.DataTransferObjects.EditSupplierDTO;
import org.springframework.http.ResponseEntity;

public interface SupplierService {
    ResponseEntity<?> save(EditSupplierDTO supplier);

    ResponseEntity<?> getAll();

    ResponseEntity<?> delete(Long id);

    ResponseEntity<?> edit(Long id, EditSupplierDTO supplierDTO);
}
