package com.ims.ims_backend.DataTransferObjects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserDTO {
    @NotBlank
    private String fullName;
    @NotBlank
    @Email
    private String userEmail;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String role;
    @NotBlank
    private String experience;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public UserDTO(String fullName, String userEmail, String phoneNumber, String role, String experience, String username, String password) {
        this.fullName = fullName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.experience = experience;
        this.username = username;
        this.password = password;
    }

    public UserDTO() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public String getExperience() {
        return experience;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
