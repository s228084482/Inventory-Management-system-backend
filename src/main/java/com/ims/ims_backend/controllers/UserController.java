package com.ims.ims_backend.controllers;

import com.ims.ims_backend.DataTransferObjects.EditUserDTO;
import com.ims.ims_backend.DataTransferObjects.UserDTO;
import com.ims.ims_backend.services.UserListener;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserListener userService;
    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user){
        return userService.saveUsers(user);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers(){
        return userService.fillAllUsers();
    }
    @GetMapping("/active")
    public long getActiveUsers(){
        return userService.getActiveUsers();
    }
    @GetMapping("/total")
    public long getTotalUsers(){
        return userService.getTotalUsers();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeUser(@PathVariable long id){
        return userService.removeUser(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editUser(@PathVariable long id,@Valid @RequestBody EditUserDTO user){
        return userService.editUser(id,user);
    }
    @GetMapping("/me")
    public String currentUser(Authentication authentication){
        return authentication.getName();
    }
    @GetMapping("/myProfile/{username}")
    public ResponseEntity<?> getCurrentUser(@PathVariable String username){
        return userService.getCurrentUser(username);
    }
}
