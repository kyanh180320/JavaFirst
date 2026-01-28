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
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User>createUser(@RequestBody @Valid User user){
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
//
//    @GetMapping
//    List<User> getUsers(){
//        return userService.getUsers();
//    }
//
//    @GetMapping("/{userId}")
//    User getUser(@PathVariable("userId") String userId){
//        return userService.getUser(userId);
//    }
//
//    @PutMapping("/{userId}")
//    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
//        return userService.updateUser(userId, request);
//    }
//
//    @DeleteMapping("/{userId}")
//    String deleteUser(@PathVariable String userId){
//        userService.deleteUser(userId);
//        return "User has been deleted";
//    }
}
