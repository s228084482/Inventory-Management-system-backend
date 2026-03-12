package com.ims.ims_backend.services;

import com.ims.ims_backend.DataTransferObjects.EditSupplierDTO;
import com.ims.ims_backend.entities.Supplier;
import com.ims.ims_backend.exceptions.SupplierExistException;
import com.ims.ims_backend.exceptions.SupplierNotFoundException;
import com.ims.ims_backend.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImplementation implements SupplierService{
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public ResponseEntity<?> save(EditSupplierDTO supplier) {
        if(!supplierRepository.existsBySupplierName(supplier.getSupplierName())){
            throw new SupplierExistException("The supplier already on the system.");
        }
        Supplier curSupplier = supplierRepository.save(new Supplier(supplier.getSupplierName(), supplier.getSupplierNumber(),
                supplier.getSupplierEmail()));
        return ResponseEntity.ok(curSupplier);
    }

    @Override
    public ResponseEntity<?> getAll() {
        var suppliers = supplierRepository.findAll();
        if(suppliers.isEmpty()){
            throw new SupplierNotFoundException("There are no suppliers on the system");
        }
        return ResponseEntity.ok(suppliers);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if(!supplierRepository.existsById(id)){
            throw new SupplierNotFoundException("Supplier that you are tying to delete isn't found.");
        }
        supplierRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> edit(Long id, EditSupplierDTO supplierDTO) {
        if(!supplierRepository.existsById(id)){
            throw new SupplierNotFoundException("Supplier that you are trying to edit isn't found.");
        }
        return supplierRepository.findById(id).map(supplier ->{
            //before updating element I make sure that is not the same.
            if(!supplier.getSupplierName().equals(supplierDTO.getSupplierName())){
                supplier.setSupplierName(supplierDTO.getSupplierName());
            }
            if(!supplier.getSupplierPhoneNumber().equals(supplierDTO.getSupplierNumber())){
                supplier.setSupplierPhoneNumber(supplierDTO.getSupplierNumber());
            }
            if(!supplier.getSupplierEmail().equals(supplierDTO.getSupplierEmail())){
                supplier.setSupplierEmail(supplierDTO.getSupplierEmail());
            }

            //checking if there is change made and if not I return feedback.
            if(supplier.getSupplierName().equals(supplierDTO.getSupplierName()) &&
                    supplier.getSupplierPhoneNumber().equals(supplierDTO.getSupplierNumber()) &&
                    supplier.getSupplierEmail().equals(supplierDTO.getSupplierEmail())){

                return ResponseEntity.notFound().build();
            }

            Supplier sup = supplierRepository.save(supplier);
            return ResponseEntity.ok(sup);

        }).orElse(ResponseEntity.notFound().build());
    }
}
