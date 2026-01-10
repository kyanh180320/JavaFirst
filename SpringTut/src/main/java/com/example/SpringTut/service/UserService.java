package com.example.SpringTut.service;

import com.example.SpringTut.dto.UserDTO;


import com.example.SpringTut.model.User;
import com.example.SpringTut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;






   public List<User> getUsers(){
      return userRepository.findAll();
   }


}
