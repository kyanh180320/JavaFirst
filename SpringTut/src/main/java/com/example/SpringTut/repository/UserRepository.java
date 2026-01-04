package com.example.SpringTut.repository;

import com.example.SpringTut.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    /**
     * Find user by phone number
     */
    // Optional<User> findByPhoneNumber(String phoneNumber);
}
