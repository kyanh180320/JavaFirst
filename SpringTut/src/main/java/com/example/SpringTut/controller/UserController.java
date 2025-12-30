package com.example.SpringTut.controller;

import com.example.SpringTut.dto.request.UserRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    @PostMapping("/")
   public String addUser(@RequestBody UserRequestDTO userDTO){
        return "User added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@RequestParam int userId, @RequestBody UserRequestDTO){
        System.out.println("Update user");
        return "User updated";
    }
    @PatchMapping("/{userId}")
    public String changeUserStatus(@RequestParam boolean enabale){
        return "User status changed";
    }



}
