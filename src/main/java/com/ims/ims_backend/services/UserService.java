package com.ims.ims_backend.services;

import com.ims.ims_backend.entities.Users;

import java.util.List;

public interface UserService {
    public Users saveUsers(Users user);

    public List<Users> fillAllUsers();

    long getActiveUsers();

    long getTotalUsers();
}
