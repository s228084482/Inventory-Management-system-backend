package com.ims.ims_backend.services;

import com.ims.ims_backend.DataTransferObjects.EditUserDTO;
import com.ims.ims_backend.DataTransferObjects.UserDTO;
import com.ims.ims_backend.entities.UserRole;
import com.ims.ims_backend.entities.Users;
import com.ims.ims_backend.exceptions.UserExistsException;
import com.ims.ims_backend.exceptions.UserNotFoundException;
import com.ims.ims_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImplementation implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> saveUsers(UserDTO user) {
        if(userRepository.existsUsersByUsername(user.getUsername())){
            throw new UserExistsException("Username already exists");
        }
        if(userRepository.existsUsersByEmail(user.getUserEmail())){
            throw new UserExistsException("This email has already exists");
        }
        Users curUser = null;
        if(user.getRole().equals("Admin")){
            curUser = new Users(user.getUsername(),passwordEncoder.encode(user.getPassword()),user.getFullName(),user.getUserEmail(),user.getPhoneNumber(),UserRole.Admin,user.getExperience(),false,"");
        }else{
            new Users(user.getUsername(),user.getPassword(),user.getFullName(),user.getUserEmail(),user.getPhoneNumber(),UserRole.Staff,user.getExperience(),false,"");
        }

        assert curUser != null;
        return ResponseEntity.ok(userRepository.save(curUser));
    }

    @Override
    public ResponseEntity<?> fillAllUsers() {
        var user = userRepository.findAll();
        if(user.isEmpty()){
            throw new UserNotFoundException("There are no users on the system.");
        }

        return ResponseEntity.ok(user);
    }

    @Override
    public long getActiveUsers() {
        long size = userRepository.countUsersByActive(true);
        if(size >= 1) return size;
        else return 0;
    }

    @Override
    public long getTotalUsers() {
        long size = userRepository.count();
        if(size >= 1) return size;
        else return 0;
    }

    @Override
    public ResponseEntity<?> removeUser(long id) {
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("User you are trying to delete isn't found, please try again.");
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> editUser(long id, EditUserDTO user) {
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("User you are trying to edit isn't found on the system, please try again.");
        }
        return userRepository.findById(id).map(curUser -> {
            if(user.getFullName().equals(curUser.getFullName()) && user.getEmail().equals(curUser.getEmail())
                    && user.getPhoneNumber().equals(curUser.getPhoneUmber()) && user.getExperience().equals(curUser.getExperience())){
//                return ResponseEntity.badRequest().body("No changes made");
                throw new UserNotFoundException("No changes made.");
            }

            if(!user.getFullName().equals(curUser.getFullName())){
                curUser.setFullName(user.getFullName());
            }
            if(!user.getEmail().equals(curUser.getEmail())){
                curUser.setEmail(user.getEmail());
            }
            if(!user.getPhoneNumber().equals(curUser.getPhoneUmber())){
                curUser.setPhoneUmber(user.getPhoneNumber());
            }
            if(!user.getExperience().equals(curUser.getExperience())){
                curUser.setExperience(user.getExperience());
            }

            Users savedUser = userRepository.save(curUser);

            return ResponseEntity.ok(savedUser);
        }).orElse(ResponseEntity.badRequest().build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = Optional.ofNullable(userRepository.findUsersByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Invalid credentials.")));


        return new org.springframework.security.core.userdetails.User(
                user.get().getUsername(), user.get().getPassword(),
                List.of(new SimpleGrantedAuthority(user.get().getRole().toString()))
        );
    }
}
