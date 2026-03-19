package com.ims.ims_backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@AllArgsConstructor
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

    private String profileURL;

    public Users(String username, String password, String fullName, String email, String phoneUmber, UserRole role, String experience, boolean active, String profileURL) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phoneUmber = phoneUmber;
        this.role = role;
        this.experience = experience;
        this.active = active;
        this.profileURL = profileURL;
    }

}
