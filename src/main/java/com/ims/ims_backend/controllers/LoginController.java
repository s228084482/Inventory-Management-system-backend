package com.ims.ims_backend.controllers;

import com.ims.ims_backend.DataTransferObjects.LoginRequest;
import com.ims.ims_backend.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class LoginController {
//    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword())
                );
        String token = JwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok().body(token);
    }
    @GetMapping("/me")
    public String currentUser(Authentication authentication){
        return authentication.getName();
    }
}
