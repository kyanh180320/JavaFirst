package com.example.SpringTut.controller;

import com.example.SpringTut.dto.UserDTO;
import com.example.SpringTut.model.User;
import com.example.SpringTut.repository.UserRepository;

import com.example.SpringTut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?>saveUser(@RequestBody UserDTO userDto){
        userService.save(userDto.convertToModel());
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
    @GetMapping("/get-all")
    public ResponseEntity<?>getAllUser(){
        List<User> users = userRepository.FindUserActive();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?>getById(@PathVariable(name = "id") long id){
        Optional<User> user = userRepository.findUser(id, true);
        if(user.isPresent())
        {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Id khong ton tai", HttpStatus.OK);
        }

    }



}
