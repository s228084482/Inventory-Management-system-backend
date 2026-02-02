package com.ims.ims_backend.repositories;

import com.ims.ims_backend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    @Query(value = "SELECT COUNT(*) FROM Users",nativeQuery = true)
    long countTotalUsers();
    @Query(value = "SELECT COUNT(*) FROM Users WHERE active = true", nativeQuery = true)
    long countActiveUsers();
}
