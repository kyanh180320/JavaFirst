package com.example.SpringTut.service;
import com.example.SpringTut.model.User;
import com.example.SpringTut.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional; // Dùng cái này!
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername()))
        {
            throw new IllegalArgumentException("Username already exists");
        }
        if(userRepository.existsByEmail(user.getEmail()))
        {
            throw new IllegalArgumentException("Email alreade exists");
        }
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    @Transactional(readOnly = true)
    public Optional<User> getUserByUsername(String userName){
        return userRepository.findByUsername(userName);
    }
    @Transactional(readOnly = true)
    public List<User> getAllActiveUser(){
        return userRepository.findByActiveTrue();
    }
    @Transactional(readOnly = true)
    public List<User> searchUser(String name){
        return userRepository.findByFirstNameContainingIgnoreCase(name);
    }
    @Transactional
    public User updateUser(Long id, User update){
        User user = userRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setLastName(update.getLastName());
        user.setFirstName(update.getFirstName());
        user.setEmail(update.getEmail());

        return userRepository.save(user);
    }
    @Transactional
    public void deactiveUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setActive(false);
        userRepository.save(user);
    }
    @Transactional
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    @Transactional
    public Long countActiveUsers(){
        return userRepository.countByActiveTrue();
    }



}
