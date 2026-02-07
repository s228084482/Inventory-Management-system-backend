package com.ims.ims_backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    @Email
    private String email;
    @Column(nullable = false)
    private String phoneUmber;

    @Column(nullable = false)
    private UserRole role;
    @Column(nullable = false)
    private String experience;
    @Column(nullable = false)
    private boolean active;
    @Column(nullable = false)
    private String profileURL;
}
