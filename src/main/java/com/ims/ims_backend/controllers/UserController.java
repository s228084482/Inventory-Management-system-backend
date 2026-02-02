package com.ims.ims_backend.controllers;

import com.ims.ims_backend.entities.Users;
import com.ims.ims_backend.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    @PostMapping
    public Users saveUser(@RequestBody Users user){
        return userService.saveUsers(user);
    }
    @GetMapping
    public List<Users> getAllUsers(){
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
}
