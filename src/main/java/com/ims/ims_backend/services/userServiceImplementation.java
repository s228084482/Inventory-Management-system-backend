package com.ims.ims_backend.services;

import com.ims.ims_backend.entities.Users;
import com.ims.ims_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepo;

    @Override
    public Users saveUsers(Users user) {
        return userRepo.save(user);
    }

    @Override
    public List<Users> fillAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public long getActiveUsers() {
        return userRepo.countActiveUsers();
    }

    @Override
    public long getTotalUsers() {
        return userRepo.countTotalUsers();
    }
}
