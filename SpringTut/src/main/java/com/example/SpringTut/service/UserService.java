package com.example.SpringTut.service;

import com.example.SpringTut.dto.request.request.UserCreationRequest;


import com.example.SpringTut.dto.request.request.UserUpdateRequest;
import com.example.SpringTut.model.User;
import com.example.SpringTut.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists");        }
        if(userRepository.existsByEmail(user.getEmail()))
        {
            throw new IllegalArgumentException("Email alreade exists");
        }
        return userRepository.save(user);

    }


}
