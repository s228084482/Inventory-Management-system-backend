package com.ims.ims_backend.DataTransferObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditSupplierDTO {
    private String supplierName;
    private String supplierEmail;
    private String supplierNumber;
}
