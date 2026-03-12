package com.ims.ims_backend.controllers;

import com.ims.ims_backend.DataTransferObjects.EditSupplierDTO;
import com.ims.ims_backend.entities.Supplier;
import com.ims.ims_backend.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "*")
public class SupplierController {
    @Autowired
    private SupplierService service;

    @PostMapping("/saveSupplier")
    public ResponseEntity<?> saveSupplier(@RequestBody EditSupplierDTO supplier){
        return service.save(supplier);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getSuppliers(){
        return service.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeSupplier(@PathVariable Long id){
        return service.delete(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editSupplier(@PathVariable Long id, @RequestBody EditSupplierDTO supplierDTO){
        return service.edit(id,supplierDTO);
    }
}
