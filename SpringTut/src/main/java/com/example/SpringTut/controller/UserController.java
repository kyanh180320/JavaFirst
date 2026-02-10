package com.example.SpringTut.controller;

import com.example.SpringTut.dto.request.request.UserCreationRequest;

import com.example.SpringTut.dto.request.request.UserUpdateRequest;
import com.example.SpringTut.model.User;
import com.example.SpringTut.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User>createUser(@RequestBody @Valid User user){
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @PostMapping("/{id}")
    public ResponseEntity<User>getUserById(@PathVariable Long id){
        return userService.getUserById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllActiveusers(){
        List<User> users = userService.getAllActiveUser();
        return ResponseEntity.ok(users);
    }
    @PostMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String name){
        List<User> users = userService.searchUser(name);
        return  ResponseEntity.ok(users);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@Valid @RequestBody User user){
        User updateUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updateUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/count")
    public ResponseEntity<Long> countActiveUsers(){
        Long countActiveUser = userService.countActiveUsers();
        return ResponseEntity.ok(countActiveUser);
    }

}
