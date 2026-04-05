package com.ims.ims_backend.repositories;

import com.ims.ims_backend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
//    @Query(value = "SELECT COUNT(*) FROM Users",nativeQuery = true)
//    long countTotalUsers();
//
//    @Query(value = "SELECT COUNT(*) FROM Users WHERE active = true", nativeQuery = true)
//    long countActiveUsers();

    long countUsersByActive(boolean active);

    Boolean existsUsersByFullName(String fullName);
    Boolean existsUsersByUsername(String username);
    Boolean existsUsersByEmail(String email);

    Optional<Users> findUsersByUsername(String username);
}
