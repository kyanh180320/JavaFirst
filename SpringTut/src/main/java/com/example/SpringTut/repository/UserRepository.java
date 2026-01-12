package com.example.SpringTut.repository;

import com.example.SpringTut.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "Select * from tbl_user u where u.in_active = true", nativeQuery = true)
    List<User> FindUserActive();

    @Query(value = "Select * from tbl_user u where u.id = :id and u.in_active = :in_active", nativeQuery = true)
    Optional<User> findUser(@Param(value = "id") Long id, @Param(value = "in_active") boolean in_active);
}
