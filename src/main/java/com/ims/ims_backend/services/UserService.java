package com.ims.ims_backend.services;

import com.ims.ims_backend.DataTransferObjects.EditUserDTO;
import com.ims.ims_backend.DataTransferObjects.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> saveUsers(UserDTO user);

    ResponseEntity<?> fillAllUsers();

    long getActiveUsers();

    long getTotalUsers();

    ResponseEntity<?> removeUser(long id);

    ResponseEntity<?> editUser(long id, @Valid EditUserDTO user);
}
