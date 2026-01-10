package com.example.SpringTut.controller;

import com.example.SpringTut.dto.UserDTO;
import com.example.SpringTut.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/save")
    public ResponseEntity<?>saveUser(@RequestBody UserDTO userDto){
        userRepository.save(userDto.convertToModel());
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }


}
