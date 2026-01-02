package com.example.SpringTut.controller;

import com.example.SpringTut.dto.request.user.UserRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList; // Nếu bạn cần khởi tạo list bằng ArrayList
@RestController
@RequestMapping("/api/v1/users")
public class UserControler {
    @PostMapping("/")
    public String addUser(@RequestBody UserRequestDTO user){
        return "User added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody UserRequestDTO user){
        System.out.println("update user");
        return "User updated";
    }
    @PatchMapping("/{userId}")
    public String changeUserStatus(@PathVariable int userId, @RequestBody boolean status){
        return "User Statsus";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId){
        return "user deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId){
       return  new UserRequestDTO("ANH","Pham", "anh@gmail.com", "1324132412");
    }
    @GetMapping("/List")
    public List<UserRequestDTO> getAllUsers(@RequestParam(required = false) String email,  @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        System.out.println("Request get user list");
        return List.of(new UserRequestDTO("anh", "tay", "1@gmail.com", "134134"),
                new UserRequestDTO("ha", "mai", "d@gmail.com", "1341324"));
    }



}
