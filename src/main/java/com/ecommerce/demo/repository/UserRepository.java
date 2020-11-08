package com.ecommerce.demo.repository;

import com.ecommerce.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Stored Procedures
    @Query(value = "CALL SelectUserByEmail(:email)", nativeQuery = true)
    List<User> findUserByEmail(@Param("email") String email);
}
