package com.ims.ims_backend.DataTransferObjects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class EditSupplierDTO {
    @NotBlank
    private String supplierName;
    @NotBlank
    @Email
    private String supplierEmail;
    @NotBlank
    private String supplierNumber;

    public EditSupplierDTO(String supplierName, String supplierEmail, String supplierNumber) {
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.supplierNumber = supplierNumber;
    }

    public EditSupplierDTO() {
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }
}
