package com.example.ecommerce.user;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (first_name, last_name, email, username, password, created_at, updated_at) VALUES (:firstName, :lastName, :email, :username, :password, NOW(), NOW())", nativeQuery = true)
    int save(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("email") String email,
            @Param("username") String username,
            @Param("password") String password
    );

    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    Optional<User> findByUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM users WHERE id = :id", nativeQuery = true)
    Optional<User> findByIdNative(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET first_name = :firstName, last_name = :lastName WHERE id = :id", nativeQuery = true)
    int updateById(
            @Param("id") Long id,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName
    );
}
