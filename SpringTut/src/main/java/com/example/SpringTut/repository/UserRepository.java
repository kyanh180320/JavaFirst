package com.example.SpringTut.repository;

import com.example.SpringTut.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    List<User> findByActiveTrue();

    List<User> findByFirstNameContainingIgnoreCase(String firstName);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    long countByActive(boolean status);

    //Custom JPQL
//    @Query("SELECT u FROM User WHERE u.createdAt >= :date ")
//    List<User> findUsersCreatedAfter(@Param("date") LocalDateTime date);

    @Query("SELECT u FROM User u WHERE u.createdAt >= :date")
    List<User> findUsersCreatedAfter(@Param("date") LocalDateTime date);


    @Query(value = "SELECT * FROM users WHERE active = true AND created_at >= :date",
            nativeQuery = true)
    List<User> findActiveUsersCreatedAfter(@Param("date") LocalDateTime date);


}
