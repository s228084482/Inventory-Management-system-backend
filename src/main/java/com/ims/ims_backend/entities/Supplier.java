package com.ims.ims_backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supplierID;
    @Column(nullable = false)
    private String supplierName;
    @Column(nullable = false)
    private String supplierPhoneNumber;
    @Column(nullable = false)
    @Email
    private String supplierEmail;
}
